package com.exalt.resourcemanagementsystem;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

/**
 * The type Resource management.
 */
@Path("/resource-management")
public class ResourceManagement {

    /**
     * Hello string.
     *
     * @return the string
     */
    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }
}