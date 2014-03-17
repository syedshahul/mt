package com.loycl.mt.service.impl;

import com.loycl.mt.emit.SampleEmitter;
import com.loycl.mt.model.Sample;
import com.loycl.mt.service.SampleManager;
import com.loycl.mt.utils.status.exception.MTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;


/**
 * @author: Syed Shahul
 */
@Service("sampleManager")
public class SampleManagerImpl extends BaseManagerImpl
	implements SampleManager {

	private SampleEmitter sampleEmitter;

	@Override public Sample getService() throws MTException {
		System.out.println("service layer call...");
		sampleEmitter.emmit();
		return new Sample("sample");
	}

	@Autowired
	public void setSampleEmitter(SampleEmitter sampleEmitter) {
		this.sampleEmitter = sampleEmitter;
	}
}
