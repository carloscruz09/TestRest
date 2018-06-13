/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service_rest.application.Helpers;

import com.service_rest.application.modelo.Domicilio;
import com.service_rest.application.modelo.Role;
import com.service_rest.application.modelo.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author amk-diseno
 */
public class SourceHelper {

    public List<User> users = new ArrayList<>();
    public User user ;

    public SourceHelper() {
        loadSampleData();
    }

    private void loadSampleData() {
        users.add(new User("223","charlie", "superSecret", new Role("ADMINISTRADOR", "ADMINISTRADOR DEL SISTEMA"), new Domicilio("Eucalipto", "252","345","Anibal Ponce")));
        users.add(new User("224","carlos", "superSecret", new Role("USUARIO", "USUARIO NORMAL EN EL SISTEMA"), new Domicilio("Ciruelo", "34-3","345","Las Palmas")));
    }
    
    private User findUserData(String id) {
        for(User user: users){
           if(user.getId().equals(id)){
             return user;  
           } 
        }
        
        return null;
    }
    
    private void addUserData(User user){
        users.add(user);
    }
    
    private void deleteUserData(String id){
        User usuarioEncontrado = new User();
        for(User user: users){
           if(user.getId().equals(id)){
             usuarioEncontrado =  user;  
           } 
        }
        users.remove(usuarioEncontrado);
    }

    public List<User> getUsers() {
        return users;
    }
    
     public User findUser(String id) {
        user = this.findUserData(id);
        return user;
    }
     
    public void addUser(User user){
        this.addUserData(user);
    }
    
    public void deleteUser(String id){
        this.deleteUserData(id);
    }
}
