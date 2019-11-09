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
public class Team {
    
    private int id;
    private String name;

    public Team(int id,String name) {
        this.id = id;
        this.name = name;
    }
    
    public Team(String name){
        this(0,name);
    }
    
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }
   
    
}
