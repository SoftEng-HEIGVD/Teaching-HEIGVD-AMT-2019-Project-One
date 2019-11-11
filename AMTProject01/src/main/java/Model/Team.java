/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.List;

/**
 *  Class representing a Team with an id , a name and a creator id
 * 
 * @author goturak
 */
public class Team {
    
    private int id;
    private String name;
    private int creatorId;
    /**
     * builder
     * @param id
     * @param name 
     */
    public Team(int id,String name) {
        this.id = id;
        this.name = name;
    }
    /**
     * 
     * @param name 
     */
    public Team(String name){
        this(0,name);
    }
    
    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }
   
    
}
