/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exceptions;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author Jonas
 */
public class NotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {
 @Context
    ServletContext context;
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public Response toResponse(NotFoundException e) {
        boolean isDebug = context.getInitParameter("debug").equals("true");

        Exceptions.ErrorMessage err = new Exceptions.ErrorMessage(e, 404, isDebug);
        err.setDescription("Tried to call...");
        err.setMessage("The requested service does not exist");

        return Response.status(404).entity(gson.toJson(err)).type(MediaType.APPLICATION_JSON).build();
    }
    
}