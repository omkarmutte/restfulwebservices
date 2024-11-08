package com.bookstore.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

import java.security.SecureRandom;
import java.util.stream.DoubleStream;

@Path("/book")
/*
    1. Unique addressable and accessible URI
    ----------------------------------------
        -> If a class is annotated with @Path annotation, then it is called "root resource class"
*/
public class BookResource {
    @GET
    /*
        2. Uniform Constrained Interfaces
        ---------------------------------
        -> Each method should be associated with an protocol operations to achieve uniform constrained interface, this can be done through http method designators like @GET, @POST, @PUT, @DELETE
        -> If a method within the root resource class is annotated with HTTP method designator annotations then that method is called "Resource Method"
    */
    @Produces("text/plain")
    /*
        3. Representation oriented
        --------------------------
            -> The resource should be able to communicate with the client in representation format he has requested. So inorder to support this the developer has to write the code in the resource method to produce the data in different formats
            -> To indicate a resource method produces the data in which format the resource method should be annotated with @Produces(MediaType.<name>) or returns
     */
    public double getBookPrice(@QueryParam("isbn") String isbn) {
        SecureRandom random = new SecureRandom();
        DoubleStream bookPrice = random.doubles(1000, 2000);
        return bookPrice.findFirst().getAsDouble();
    }
}
