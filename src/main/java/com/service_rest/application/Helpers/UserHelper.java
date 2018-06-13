/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.Helpers;

import com.service_rest.application.modelo.SendUser;
import com.service_rest.application.modelo.User;

/**
 *
 * @author aco-ec-029
 */
public class UserHelper {
    
    public SendUser converterUser(User user){
       SendUser sendUser = new SendUser();
       sendUser.setUsername(user.getUsername());
       sendUser.setPassword(user.getPassword());
       sendUser.setRoleName(user.getRole().getName());
       sendUser.setRoleDescription(user.getRole().getDescription());
       sendUser.setAddressStreet(user.getDomicilio().getCalle());
       sendUser.setAddressIntNumber(user.getDomicilio().getNumeroInt());
       sendUser.setAddressExtNumber(user.getDomicilio().getNumeroExt());
       sendUser.setAddressNeighbourhood(user.getDomicilio().getColonia());
       return sendUser;
    }
    
}
