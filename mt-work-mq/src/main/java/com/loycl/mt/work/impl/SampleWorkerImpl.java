package com.loycl.mt.work.impl;

import com.google.common.base.Strings;
import com.loycl.mt.utils.status.exception.MTException;
import com.loycl.mt.work.SampleWorker;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger LOGGER =
		LoggerFactory.getLogger(SampleWorkerImpl.class);

	@Override public void onMessage(Message message, Channel channel)
		throws Exception {
		LOGGER.info("onMessage : {}", new String(message.getBody()));
	}

}
