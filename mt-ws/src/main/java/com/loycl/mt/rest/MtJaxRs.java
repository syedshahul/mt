package com.loycl.mt.rest;

import com.loycl.mt.utils.status.exception.MTException;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author: Syed Shahul
 */
@Path("mt")
@Produces(
		{MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
				MediaType.APPLICATION_ATOM_XML})
public interface MtJaxRs {

	@POST
	@Path("/push")
	Response pushMT(String inputJson) throws MTException;
}
