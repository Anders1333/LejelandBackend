/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Item;
import Entities.User;
import com.google.gson.Gson;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author AndersHC
 */
public class UserFacade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("lejelandPU");
    
    
    
    public List<String> getAllUsers(){
   
    EntityManager em = emf.createEntityManager();
    List<String> res = em.createQuery("SELECT u FROM User u").getResultList();
    return res;
    }
    
    public User getUserFromId(int id){
    EntityManager em = emf.createEntityManager();
    User user = (User) em.createQuery("SELECT u FROM User u WHERE u.id ="+ id).getSingleResult();
    return user;
    }

    public User getUserFromJson(String json) {
  
    return new Gson().fromJson(json, User.class);
    }
    
    
}
