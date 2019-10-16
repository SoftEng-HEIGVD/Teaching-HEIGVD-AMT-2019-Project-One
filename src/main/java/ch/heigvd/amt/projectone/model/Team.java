package ch.heigvd.amt.projectone.model;

import lombok.Builder;
import lombok.Getter;

import java.util.LinkedList;

@Builder
@Getter
public class Team {
    private String name;
    private LinkedList<Player> players;
}
