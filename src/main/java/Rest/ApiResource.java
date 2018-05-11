/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entities.Item;
import Entities.User;
import Errorhandling.Gatekeeper;
import Exceptions.ValidationErrorException;
import Facades.ItemFacade;
import Facades.UserFacade;
import com.google.gson.Gson;
import static java.awt.SystemColor.window;
import static java.lang.System.console;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import java.lang.System;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;

/**
 * REST Web Service
 *
 * @author AndersHC
 */
@Path("api")
public class ApiResource{

    ItemFacade IF = new ItemFacade();
    UserFacade UF = new UserFacade();
    Gson gson = new Gson();
    Gatekeeper GK = new Gatekeeper();
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("lejelandPU");
    EntityManager em = emf.createEntityManager(); 
            

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiResource
     */
    public ApiResource() {
    }

    /**
     * Retrieves representation of an instance of Controllers.ApiResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        return "This is the API. Hello!";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/users")
    public String getAllUsers() {
        return gson.toJson(UF.getAllUsers());

    }

    @Path("/users/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserFromId(@PathParam("userId") Integer id) {
        return gson.toJson(UF.getUserFromId(id));
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/items")
    public String getAllItems() {
        return gson.toJson(IF.getAllItems());
    }

    @Path("/items/{itemId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getItemFromId(@PathParam("itemId") Integer id) {
        return gson.toJson(IF.getItemFromId(id));
    }

    @Path("/users/{userId}/items")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getItemsForUser(@PathParam("userId") Integer id) {
        return gson.toJson(IF.getItemsFromUserId(id));
    }

    @Path("/items/category/{categoryName}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getItemsFromCategory(@PathParam("categoryName") String category) {
        return gson.toJson(IF.getItemsFromCategory(category));
    }

    @Path("/items/addItem")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addItemToDatabase(String content){
        Item item = IF.getItemFromJson(content);
         try{
            em.getTransaction().begin();
            em.persist(item);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
       return item.toString();
    }
    
    @Path("/users/addUser")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String addUserToDatabase(String content) throws ValidationErrorException {
        User user = UF.getUserFromJson(content);
        if(GK.checkUserData(user)==false){
          throw new ValidationErrorException("Code: 404   Message: Invalid input.");  
        }
         try{
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        } finally{
            em.close();
        }
       return user.toString();
    }
}
  

    
    
    
    

