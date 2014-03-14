package com.loycl.mt.rest.impl;

import com.loycl.mt.rest.SampleRest;
import com.loycl.mt.utils.status.exception.MTException;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

/**
 * @author: Syed Shahul
 */
@Service("sampleRest")
public class SampleRestImpl extends BaseRestImpl implements SampleRest {
	@Override public Response getSample() throws MTException {
		return Response.ok().entity(sampleManager.getService()).build();
	}
}
