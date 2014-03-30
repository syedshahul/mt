package com.loycl.mt.emit.impl;

import com.google.common.base.Strings;
import com.loycl.mt.emit.SampleEmitter;
import com.loycl.mt.utils.status.exception.MTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Syed Shahul
 */
@Configuration("sampleEmitter")
public class SampleEmitterImpl implements SampleEmitter{
	private static final Logger LOGGER =
		LoggerFactory.getLogger(SampleEmitterImpl.class);

	private RabbitTemplate amqpTemplate;

	@Override public void emmit() throws MTException {
		int i;
		for (i=0;i<100;i++){
		  LOGGER.info(Strings.padStart((""+i),3,'0'));
			amqpTemplate.convertAndSend(Strings.padStart((""+i),3,'0'));
		}
	}

	@Qualifier("amqpTemplate")
	@Autowired
	public void setAmqpTemplate(RabbitTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}
}
