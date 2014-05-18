package com.loycl.mt.rest.impl;

import com.loycl.mt.model.MtRequest;
import com.loycl.mt.rest.MtJaxRs;
import com.loycl.mt.service.MtManager;
import com.loycl.mt.utils.conversion.MapperUtil;
import com.loycl.mt.utils.status.exception.MTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.core.Response;

/**
 * @author: Syed Shahul
 */
@Service("mtJaxRs")
public class MtJaxRsImpl implements MtJaxRs {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(MtJaxRsImpl.class);

	private MtManager mtManager;

	@Override
	public Response pushMT(String inputJson) throws MTException {
		/**
		 * mobile_no
		 * msg
		 * reference_no
		 */
		MtRequest mtRequest = MapperUtil.readAsObjectOf(MtRequest.class,
		                                                inputJson);
		    /*if(LOGGER.isInfoEnabled()){
			LOGGER.info("inputJson : {} \nmtRequest : {}", inputJson,
			            mtRequest.toString());
		}*/
		return Response.ok().entity(mtManager.pushMT(mtRequest)).build();
	}

	@Autowired
	public void setMtManager(MtManager mtManager) {
		this.mtManager = mtManager;
	}
}
