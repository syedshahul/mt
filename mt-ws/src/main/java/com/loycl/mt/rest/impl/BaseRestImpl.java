package com.loycl.mt.rest.impl;


import com.loycl.mt.service.SampleManager;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: Syed Shahul
 */
public class BaseRestImpl {
	protected SampleManager sampleManager;

	@Autowired
	public void setSampleManager(SampleManager sampleManager) {
		this.sampleManager = sampleManager;
	}
}
