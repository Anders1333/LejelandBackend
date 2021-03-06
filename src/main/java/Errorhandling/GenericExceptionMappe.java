/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errorhandling;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.servlet.ServletContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

/**
 *
 * @author Jonas
 */
public class GenericExceptionMappe implements ExceptionMapper<Throwable> {

      @Context
    ServletContext context;
    
    static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Override
    public Response toResponse(Throwable ex) {
        boolean isDebug = context.getInitParameter("debug").equals("true");

        ErrorMessage err = new ErrorMessage(ex, 500, isDebug);
        err.setDescription("Tried to call...");
        err.setMessage("Internal Server Problem. We are sorry for the inconvenience");

        return Response.status(500).entity(gson.toJson(err)).type(MediaType.APPLICATION_JSON).build();
    }
    
}
