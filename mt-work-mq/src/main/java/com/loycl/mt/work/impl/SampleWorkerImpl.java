package com.loycl.mt.work.impl;

import com.loycl.mt.utils.status.exception.MTException;
import com.loycl.mt.work.SampleWorker;
import org.springframework.context.annotation.Configuration;

/**
 * @author: Syed Shahul
 */
@Configuration("sampleWorker")
public class SampleWorkerImpl implements SampleWorker{
	@Override public void receive(String data) throws MTException {
	 System.out.println("sampleWorker : "+data);

	}
}
