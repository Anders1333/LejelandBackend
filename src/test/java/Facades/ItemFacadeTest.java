/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.Item;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import javax.persistence.*;
/**
 *
 * @author jonas
 */
public class ItemFacadeTest {
    
    public ItemFacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllItems method, of class ItemFacade.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        ItemFacade instance = new ItemFacade();
        int expResult = 32;
        int result = instance.getAllItems().size();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getItemFromId method, of class ItemFacade.
     */
    @Test
    public void testGetItemFromId() {
        System.out.println("getItemFromId");
        Integer id = 44;
        ItemFacade instance = new ItemFacade();
        String expResult = "Big Bathroom mirror";
        String result = instance.getItemFromId(id).getTitle();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getItemsFromUserId method, of class ItemFacade.
     */
    @Test
    public void testGetItemsFromUserId() {
        System.out.println("getItemsFromUserId");
        Integer id = 5;
        ItemFacade instance = new ItemFacade();
        int expResult = 4;
        int result = instance.getItemsFromUserId(id).size();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getItemsFromCategory method, of class ItemFacade.
     */
    @Test
    public void testGetItemsFromCategory() {
        System.out.println("getItemsFromCategory");
        String category = "Cars";
        ItemFacade instance = new ItemFacade();
        int expResult = 3;
        int result = instance.getItemsFromCategory(category).size();
        assertEquals(expResult, result);
        
    }
    
}
