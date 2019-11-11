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
    
    private int id;
    private String userName;
    private String name;
    private Team team;
    private int creatorId;

    
    public Player(String userName, String name,int creatorId) {
        this(0,userName,name,new Team(1,"no_team"),creatorId);
    }

    
    public Player(int id,String userName, String name, Team team, int creatorId) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.team = team;
        this.creatorId=creatorId;
    }

    public int getCreatorId() {
        return creatorId;
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
    
   public int getId(){
       return id;
   }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Player)){
            return false;
        }
        Player p= (Player)obj;
        return p.getUserName().equals(this.userName); //To change body of generated methods, choose Tools | Templates.
    }
    
       
}
