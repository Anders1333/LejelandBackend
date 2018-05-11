/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errorhandling;

import Entities.User;

/**
 *
 * @author AndersHC
 */
public class Gatekeeper {
    
    
    public boolean checkUserData(User user){
      return !(user.getId()!=0 || 
              user.getEmail().equals("") ||
              user.getName().equals("") ||
              user.getPassword().equals("") ||
              user.getNumberOfRatings()!=0 ||
              user.getSumOfRatings()!=0);
    }
}
