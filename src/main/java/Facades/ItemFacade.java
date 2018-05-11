/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Item;
import com.google.gson.Gson;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author AndersHC
 */
public class ItemFacade {
    
EntityManagerFactory emf = Persistence.createEntityManagerFactory("lejelandPU");
 EntityManager em = emf.createEntityManager();   
     
     
    public List<String> getAllItems(){
     
     List<String> res = em.createQuery("SELECT i FROM Item i").getResultList();
     return res;
    }

    public Item getItemFromId(Integer id) {
    Item item = (Item) em.createQuery("SELECT i FROM Item i WHERE i.itemId= "+ id).getSingleResult();
    return  item;
    }

    public List<String> getItemsFromUserId(Integer id) {
    List<String> res = em.createQuery("SELECT i FROM Item i WHERE i.userId= "+id).getResultList();
    return res;
    }

    public List<String> getItemsFromCategory(String category) {
   
    Query q = em.createQuery("SELECT i FROM Item i WHERE i.category= :category");
    q.setParameter("category", category);
    List<String> res = q.getResultList();
    return res;
    }
    
     public Item getItemFromJson(String json) {
        return new Gson().fromJson(json, Item.class);
    }
}
