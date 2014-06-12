package com.example;

import javax.ws.rs.*;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
/**
 * Root resource (exposed at "todos" path)
 */
@Path("/todos")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String get() {
        return "Getting";
    }
    @GET 
    @Path("/search/?q={term}")
    @Produces(MediaType.TEXT_PLAIN)
    public String searchByTerm(@PathParam("term") String term) {
        return "searching "+term;
    }
    @GET 
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String getTodoById(@PathParam("id") String id) {
        return "getting "+id;
    }

    @DELETE 
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String delete(@PathParam("id") String id) {
        return "Deleting todo for "+id;
    }

    @PUT
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String update(@PathParam("id") String id,@FormParam("name") String name) {
        return "Updating todo for "+id +" new name "+name;
    }

    @PATCH 
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    public String patch(@PathParam("id") String id) {
        return "patching todo for "+id;
    }

    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String create(@FormParam("name") String name) {
        return "Creating "+name;
    }
     
    
}
