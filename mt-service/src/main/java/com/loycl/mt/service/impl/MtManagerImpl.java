package com.loycl.mt.service.impl;

import com.loycl.mt.emit.MtProducer;
import com.loycl.mt.model.MtRequest;
import com.loycl.mt.model.MtResponse;
import com.loycl.mt.service.MtManager;
import com.loycl.mt.utils.status.exception.MTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: Syed Shahul
 */
@Service("mtManager")
public class MtManagerImpl implements MtManager {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(MtManagerImpl.class);

	private MtProducer mtProducer;

	@Override
	public MtResponse pushMT(MtRequest mtRequest) throws MTException {
	/*	if(LOGGER.isInfoEnabled()){
			LOGGER.info("MtManagerImpl->pushMT");
		}*/
		return mtProducer.pushMT(mtRequest);
	}

	@Override
	public void processMT(MtRequest mtRequest) throws MTException {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("MtManagerImpl->processMT : {}", mtRequest.toString());
		}
	}

	@Autowired
	public void setMtProducer(MtProducer mtProducer) {
		this.mtProducer = mtProducer;
	}

}
