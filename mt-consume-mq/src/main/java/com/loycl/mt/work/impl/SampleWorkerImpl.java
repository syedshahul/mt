package com.loycl.mt.work.impl;

import com.loycl.mt.model.MtRequest;
import com.loycl.mt.service.MtManager;
import com.loycl.mt.work.conversion.AmqpUtil;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.ChannelAwareMessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;


/**
 * @author: Syed Shahul
 */
@Configuration("sampleWorker")
public class SampleWorkerImpl implements ChannelAwareMessageListener {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(SampleWorkerImpl.class);

	private MtManager mtManager;

	@Override
	public void onMessage(Message message, Channel channel) throws Exception {
		/*if(LOGGER.isInfoEnabled()){
		   LOGGER.info("onMessage : {}", new String(message.getBody()));
		}*/

		switch (message.getMessageProperties().getType()) {
			case "MtRequest":
				mtManager.processMT((MtRequest) AmqpUtil.convertMessage(message));
		}
		channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);
	}

	@Autowired
	public void setMtManager(MtManager mtManager) {
		this.mtManager = mtManager;
	}
}
