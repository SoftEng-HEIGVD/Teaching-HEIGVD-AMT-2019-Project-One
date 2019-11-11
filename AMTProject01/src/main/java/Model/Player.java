/**
 * Model of Player
 * 
 */
package Model;

/**
 *  class representing a Player with an id, username, name, team and creator id
 * @author goturak
 */
public class Player {
    
    private int id;
    private String userName;
    private String name;
    private Team team;
    private int creatorId;

    /**
     * Builder
     * @param userName
     * @param name
     * @param creatorId 
     */
    public Player(String userName, String name,int creatorId) {
        
        this(0,userName,name,new Team(1,"no_team"),creatorId);
    }

    /**
     * 
     * @param id
     * @param userName
     * @param name
     * @param team
     * @param creatorId 
     */
    public Player(int id,String userName, String name, Team team, int creatorId) {
        
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.team = team;
        this.creatorId=creatorId;
    }
    
    /**
     * 
     * @return creatorId
     */
    public int getCreatorId() {
        
        return creatorId;
    }

    /**
     * 
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 
     * @return name 
     */
    public String getName() {
        
        return name;
    }

    /**
     * 
     * @return team
     */
    public Team getTeam() {
        
        return team;
    }
    
    /**
     * 
     * @return id
     */
    public int getId(){
       return id;
    }

    /**
     * 
     * @param obj
     * @return 
     */
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Player)){
            return false;
        }
        Player p= (Player)obj;
        return p.getUserName().equals(this.userName); //To change body of generated methods, choose Tools | Templates.
    }
    
       
}
