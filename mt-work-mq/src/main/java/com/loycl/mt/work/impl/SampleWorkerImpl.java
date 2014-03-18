package com.loycl.mt.work.impl;

import com.loycl.mt.utils.status.exception.MTException;
import com.loycl.mt.work.SampleWorker;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Syed Shahul
 */
@Configuration("sampleWorker")
public class SampleWorkerImpl implements ChannelAwareMessageListener{
	//private RabbitTemplate amqpTemplate;

	@Override public void onMessage(Message message, Channel channel)
		throws Exception {
		System.out.println("onMessage : "+message.getBody());
	}


	/*@Override public void receive(String data) throws MTException {
	 System.out.println("sampleWorker : "+data);
	}*/

	/*@Override public void receiveA() throws MTException {
		System.out.println("receiveA : "+amqpTemplate.receive());
	}
*/
	/*@Autowired
	public void setAmqpTemplate(RabbitTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}*/
}
