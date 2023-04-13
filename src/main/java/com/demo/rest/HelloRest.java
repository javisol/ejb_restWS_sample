package com.demo.rest;

//import javax.ws.rs.Consumes; 
import javax.ws.rs.GET; 
import javax.ws.rs.Path; 
import javax.ws.rs.Produces; 
import javax.ws.rs.core.MediaType; 
import javax.ws.rs.core.Response; 

@Path("/hello") 
@Produces(MediaType.TEXT_PLAIN) 
//@Produces(MediaType.APPLICATION_JSON) 
//@Consumes(MediaType.APPLICATION_JSON) 
public class HelloRest {

    @GET  
    public Response sayHello() {
        return Response.ok("Hello World desde el API REST",MediaType.TEXT_PLAIN).build();   
    } 
}
