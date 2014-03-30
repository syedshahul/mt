package com.loycl.mt.service;

import com.loycl.mt.model.Sample;
import com.loycl.mt.utils.status.exception.MTException;

/**
 * The interface Sample service.
 *
 * @author: Syed Shahul
 */
public interface SampleManager {
	/**
	 * Gets service.
	 *
	 * @return the service
	 */
	Sample getService() throws MTException;


}
