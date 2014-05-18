package com.loycl.mt.rest.mapper;

import com.google.common.collect.Maps;
import com.loycl.mt.model.MtExceptionResponse;
import com.loycl.mt.utils.status.exception.ErrorCodes;
import com.loycl.mt.utils.status.exception.MTException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.Map;

/**
 * @author: Syed Shahul
 */
@Service("mtRSExceptionMapper")
@Provider
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class MTRSExceptionMapper implements ExceptionMapper<MTException> {
	private static final Logger LOGGER =
			LoggerFactory.getLogger(MTRSExceptionMapper.class);

	@Override
	public Response toResponse(MTException exception) {
		LOGGER.info("exception : {}", exception.toString());
		MtExceptionResponse mtExceptionResponse = new MtExceptionResponse();
		Map<Integer, String> map = Maps.newHashMap();

		for (ErrorCodes errorCodes : exception.getErrorCodes()) {
			map.put(errorCodes.getErrorCode(), errorCodes.getErrorMessage());
		}
		mtExceptionResponse.setErrorMsgs(map);
		return Response.status(exception.getErrorCodes().get(0).getErrorCode())
				.entity(mtExceptionResponse).build();
	}
}
