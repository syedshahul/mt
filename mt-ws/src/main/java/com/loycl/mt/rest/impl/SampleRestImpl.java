package com.loycl.mt.rest.impl;

import com.loycl.mt.rest.SampleRest;
import com.loycl.mt.service.SampleManager;
import com.loycl.mt.utils.status.exception.MTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

/**
 * @author: Syed Shahul
 */
@Service("sampleRest")
public class SampleRestImpl implements SampleRest {

	private static final Logger LOGGER =
			LoggerFactory.getLogger(SampleRestImpl.class);

	private SampleManager sampleManager;

	@Override
	public Response getSample() throws MTException {
		if (LOGGER.isInfoEnabled()) {
			LOGGER.info("info WSR layer");
		}
		if (LOGGER.isWarnEnabled()) {
			LOGGER.warn("warn WSR layer");
		}
		LOGGER.info("info wo WSR layer");
		return Response.ok().entity(sampleManager.getService()).build();
	}

	@Autowired
	public void setSampleManager(SampleManager sampleManager) {
		this.sampleManager = sampleManager;
	}
}
