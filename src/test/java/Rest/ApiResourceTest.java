/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Rest;

import Entities.Item;
import Facades.ItemFacade;
import com.google.gson.Gson;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.NullPointerException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jonas
 */
public class ApiResourceTest {

    String setUpdata;
    Gson gson = new Gson();

    public ApiResourceTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        ApiResource instance = new ApiResource();
        String category = "babysitting";
        String setUpdata = instance.getItemsFromCategory(category);

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getJson method, of class ApiResource.
     */
    @Test
    public void testGetJson() {
        System.out.println("getJson");
        ApiResource instance = new ApiResource();
        String expResult = "";
        String result = instance.getJson();
        assertNotNull(result);
    }

    /**
     * Test of getAllUsers method, of class ApiResource.
     */
    @Test
    public void testGetAllUsers() {
        System.out.println("getAllUsers");
        ApiResource instance = new ApiResource();

        String result = instance.getAllUsers();
        assertNotNull(result);

    }

    /**
     * Test of getUserFromId method, of class ApiResource.
     */
    @Test
    public void testGetUserFromId() {
        System.out.println("getUserFromId");
        Integer id = 2;
        ApiResource instance = new ApiResource();
        String expResult = "";
        String result = instance.getUserFromId(id);
        assertNotNull(result);
    }

    /**
     * Test of getAllItems method, of class ApiResource.
     */
    @Test
    public void testGetAllItems() {
        System.out.println("getAllItems");
        ApiResource instance = new ApiResource();
        int expResult = 6;
        String result = instance.getAllItems();
        assertNotSame(result, null);

    }

    /**
     * Test of getItemFromId method, of class ApiResource.
     */
    @Test
    public void testGetItemFromIdNotNull() {
        System.out.println("getItemFromId");
        Integer id = 6;
        ApiResource instance = new ApiResource();

        String result = instance.getItemFromId(id);
        assertNotNull(result);
    }
     @Test
    public void testGetItemFromIdSuccess() {
        System.out.println("getItemFromId");
        Integer id = 6;
        ApiResource instance = new ApiResource();
        String data = instance.getItemFromId(id);
        Item item = gson.fromJson(data, Item.class);
        int expResult = 6;
        int result = item.getItemId();
        assertEquals(result,expResult);
    }

    /**
     * Test of getItemsForUser method, of class ApiResource.
     */
    @Test
    public void testGetItemsForUser() {
        System.out.println("getItemsForUser");
        int id = 4;
        ItemFacade it = new ItemFacade();
        List<String> itemsAsStrings = it.getItemsFromUserId(id);
        List<Item> itemsInList = new ArrayList<Item>();
        
        for (int i = 0; i < itemsAsStrings.size(); i++) {
           itemsInList.add(gson.fromJson(itemsAsStrings.get(i),Item.class));
          }
        
        // FORTSÆT HER YO
       
     
       
        
        
        
        
    }

    /**
     * Test of getItemsFromCategory method, of class ApiResource.
     */
    @Test
    public void testGetItemsFromCategory() {
        System.out.println("getItemsFromCategory");
        String category = "babysitting";
        ApiResource instance = new ApiResource();
        String result = instance.getItemsFromCategory(category);
        assertNotEquals(result, null);
        // assertEquals(result,setUpdata);

    }

    /**
     * Test of addItemToDatabase method, of class ApiResource.
     */
    @Test(expected = NullPointerException.class)
    public void testAddItemToDatabase() throws Exception {
        System.out.println("addItemToDatabase");
        String content = "";
        ApiResource instance = new ApiResource();
        String result = instance.addItemToDatabase(content);
        
    }

    /**
     * Test of addUserToDatabase method, of class ApiResource.
     */
    @Test(expected = NullPointerException.class)
    public void testAddUserToDatabase() throws Exception {
        System.out.println("addUserToDatabase");
        String content = "";
        ApiResource instance = new ApiResource();

        String result = instance.addUserToDatabase(content);

    }

}
