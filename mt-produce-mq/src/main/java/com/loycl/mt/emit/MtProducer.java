package com.loycl.mt.emit;

import com.loycl.mt.model.MtRequest;
import com.loycl.mt.model.MtResponse;
import com.loycl.mt.utils.status.exception.MTException;

/**
 * @author: Syed Shahul
 */
public interface MtProducer {
	MtResponse pushMT(MtRequest mtRequest) throws MTException;
}
