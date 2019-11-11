/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *
 * @author goturak
 */
public class User {
    
    private int id;
    private String name;
    private String pwd;
    
    public User(int id,String name) {
        this.id = id;
        this.name = name;
    }
    
    public User(String name,String pwd){
        this(0,name);
    }

    public User(int id, String name, String pwd) {
        
        this.id= id;
        this.name=name;
        this.pwd=pwd;
    }
    
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }
   
    
}
