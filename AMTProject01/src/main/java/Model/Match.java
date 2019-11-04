/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author goturak
 */
public class Match {
    private long id;
    private Player[] team1Players;
    private Player[] team2Players;
    private Team team1;
    private Team team2;
    
    private int team1EndScore;
    private int team2EndScore;

    public Match(long id,Player[] team1Players, Player[] team2Players, Team team1, Team team2, int team1EndScore, int team2EndScore) {
        if(team1Players.length!=5 || team2Players.length!=5|| (team1EndScore<15&&team2EndScore<15)){
            throw new IllegalArgumentException();
        }
        this.team1Players = team1Players;
        this.team2Players = team2Players;
        this.team1 = team1;
        this.team2 = team2;
        this.team1EndScore = team1EndScore;
        this.team2EndScore = team2EndScore;
        this.id= id;
    }

    public Match(long id,Player[] team1Players, Player[] team2Players, int team1EndScore, int team2EndScore) {
       this(id,team1Players,team2Players,null,null,team1EndScore,team2EndScore);
    }

    public Player[] getTeam1Players() {
        return team1Players;
    }

    public Player[] getTeam2Players() {
        return team2Players;
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
    
    
}
