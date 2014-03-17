package com.loycl.mt.emit.impl;

import com.loycl.mt.emit.SampleEmitter;
import com.loycl.mt.utils.status.exception.MTException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

/**
 * @author: Syed Shahul
 */
@Configuration("sampleEmitter")
public class SampleEmitterImpl implements SampleEmitter{

	private RabbitTemplate amqpTemplate;

	@Override public void emmit() throws MTException {
		int i;
		for (i=0;i<100;i++){
			System.out.println(new Date().toString());
			amqpTemplate.convertAndSend(new Date().toString());
		}
	}

	@Autowired
	public void setAmqpTemplate(RabbitTemplate amqpTemplate) {
		this.amqpTemplate = amqpTemplate;
	}
}
