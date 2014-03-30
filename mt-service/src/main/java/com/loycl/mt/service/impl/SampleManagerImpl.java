package com.loycl.mt.service.impl;

import com.loycl.mt.emit.SampleEmitter;
import com.loycl.mt.model.Sample;
import com.loycl.mt.service.SampleManager;
import com.loycl.mt.utils.status.exception.MTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author: Syed Shahul
 */
@Service("sampleManager")
public class SampleManagerImpl
	implements SampleManager {
	private static final Logger LOGGER =
		LoggerFactory.getLogger(SampleManagerImpl.class);


	private SampleEmitter sampleEmitter;

	@Override public Sample getService() throws MTException {
		LOGGER.info("service layer call...");
		sampleEmitter.emmit();
		return new Sample("sample");
	}

	@Autowired
	public void setSampleEmitter(SampleEmitter sampleEmitter) {
		this.sampleEmitter = sampleEmitter;
	}
}
