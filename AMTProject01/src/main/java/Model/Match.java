/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 * Class representing a Match entity with an id two teams 
   two end scores and a creator id
 * @author goturak 
 */
public class Match {
    private long id;
    private Team team1;
    private Team team2;
    
    private int team1EndScore;
    private int team2EndScore;
    private int creator;

    public Match(long id, Team team1, Team team2, int team1EndScore, int team2EndScore) {
//        if(team1Players.size()!=5 || team2Players.size()!=5|| (team1EndScore<15&&team2EndScore<15)){
//            throw new IllegalArgumentException();
//        }
        this.team1 = team1;
        this.team2 = team2;
        this.team1EndScore = team1EndScore;
        this.team2EndScore = team2EndScore;
        this.id= id;
    }

    public Match(long id, int team1EndScore, int team2EndScore) {
       this(id,new Team(1,"no_team"),new Team(1,"no_team"),team1EndScore,team2EndScore);
    }

    public Team getTeam1() {
        return team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public int getTeam1EndScore() {
        return team1EndScore;
    }

    public int getTeam2EndScore() {
        return team2EndScore;
    }

    public long getId() {
        return id;
    }

    public int getCreator() {
        return creator;
    }

    public void setCreator(int creator) {
        this.creator = creator;
    }
    
    
    
}
