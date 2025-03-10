package com.powernode.arocketmqdemo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import com.powernode.constant.MqConstant;

@SpringBootTest
class ARocketmqDemoApplicationTests {

	@Test
	void repeatProducer() throws Exception {
		// 创建一个生产者（指定一个组名）
		DefaultMQProducer producer = new DefaultMQProducer("repeat-producer-group");
		// 连接namesrv
		producer.setNamesrvAddr(MqConstant.NAME_SRV_ADDR);
		// 启动
		producer.start();
		// 创建一个消息
		Message message = new Message("testTopic", "我是一个简单的消息".getBytes());
		// 发送消息
		SendResult sendResult = producer.send(message);
		System.out.println(sendResult.getMessageQueue());
		// 关闭生产者
		producer.shutdown();
	}

}
