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
public class PersonNotFoundExceptionMapper implements ExceptionMapper<PersonNotFoundException>{

    @Context
    ServletContext context;
    
     static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    
    @Override
    public Response toResponse(PersonNotFoundException e) {
         boolean isDebug = context.getInitParameter("debug").equals("true");

        ErrorMessage err = new ErrorMessage(e, 404, isDebug);
        err.setDescription("Id not found...");
        err.setMessage(e.getMessage());
        
        return Response.status(404).entity(gson.toJson(err)).type(MediaType.APPLICATION_JSON).build();
    }
    
}
