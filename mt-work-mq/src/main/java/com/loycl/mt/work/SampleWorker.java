package com.loycl.mt.work;

import com.loycl.mt.utils.status.exception.MTException;

/**
 * @author: Syed Shahul
 */
public interface SampleWorker {
	void receive(String data) throws MTException;
//	void receiveA() throws MTException;
}
