/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author goturak
 */
public class Player {
    
    private String userName;
    private String name;
    private Team team;

    public Player(String userName){
        this(userName,null,null);
    }
    
    public Player(String userName, String name) {
        this(userName,name,null);
    }

    
    public Player(String userName, String name, Team team) {
        this.userName = userName;
        this.name = name;
        this.team = team;
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public Team getTeam() {
        return team;
    }
    
       
}
