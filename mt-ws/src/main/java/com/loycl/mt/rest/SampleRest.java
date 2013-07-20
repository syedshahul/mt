package com.loycl.mt.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author: Syed Shahul
 */
@Path("samplerst")
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML,
            MediaType.APPLICATION_ATOM_XML})
public interface SampleRest {
  @GET Response getSample();
}
