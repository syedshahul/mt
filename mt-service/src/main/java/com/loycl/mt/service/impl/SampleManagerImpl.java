package com.loycl.mt.service.impl;

import com.loycl.mt.model.Sample;
import com.loycl.mt.service.SampleManager;
import com.loycl.mt.utils.status.exception.MTException;
import org.springframework.stereotype.Service;


/**
 * @author: Syed Shahul
 */
@Service("sampleManager")
public class SampleManagerImpl extends BaseManagerImpl
	implements SampleManager {
	@Override public Sample getService() throws MTException {
		return new Sample("sample");
	}
}
