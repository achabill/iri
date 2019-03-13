package com.iota.iri.service.restserver;

import java.io.IOException;
import java.io.InputStream;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.iota.iri.service.dto.AbstractResponse;

@Path("")
public class Test extends ApiCall {
    
    @Context()
    private ApiProcessor requestMetadata;
    
    @Context
    HttpHeaders requestHeaders;
    
    @Context
    HttpServletRequest httpRequest;

    @Context
    Request request;
    
    public Test() {
        
    }
    
    @GET
    @Path("ping")
    public String ping() {
        return "pong";
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response apiCall(String request) throws JsonParseException, JsonMappingException, IOException {
        System.out.println("Hello: " + this.httpRequest);
        
        AbstractResponse response = pre(request);
        if (response == null) {
           response = process();
        }

        return Response.ok(post(response)).build();
    }

    private AbstractResponse process() {
        return AbstractResponse.createEmptyResponse();
    }
}
