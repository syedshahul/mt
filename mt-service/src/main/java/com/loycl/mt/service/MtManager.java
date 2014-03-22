package com.loycl.mt.service;

import com.loycl.mt.model.MtRequest;
import com.loycl.mt.model.MtResponse;
import com.loycl.mt.utils.status.exception.MTException;

/**
 * @author: Syed Shahul
 */
public interface MtManager {
	MtResponse pushMT(MtRequest mtRequest) throws MTException;
}
