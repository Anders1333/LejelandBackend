/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facades;

import Entities.User;
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
public class UserFacadeTest {
    
    public UserFacadeTest() {
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
     * Test of getAllUsers method, of class UserFacade.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        UserFacade instance = new UserFacade();
        int expResult = 8;
        int result = instance.getAllUsers().size();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of getUserFromId method, of class UserFacade.
     */
    @Test
    public void testGetUserFromId() {
        System.out.println("getUserFromId");
        int id = 3;
        UserFacade instance = new UserFacade();
        int expResult = 3;
        int resultId = instance.getUserFromId(id).getId();
        System.out.println(resultId);
        assertEquals(expResult, resultId);
        
    }
    
    @Test(expected = NoResultException.class)
    public void testGetUserFromId_worng_id() {
        System.out.println("getUserFromId");
        int id = 99;
        UserFacade instance = new UserFacade();
        int resultId = instance.getUserFromId(id).getId();
   
      
        
    }

    
    
}
