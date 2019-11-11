/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.User;


import Model.User;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benjamin
 */
public interface UserManager {
    
 
 
    public void add(User u);
    public User get(String username);
    public void delete(int id);
    
}
