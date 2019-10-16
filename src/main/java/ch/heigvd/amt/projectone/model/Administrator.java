package ch.heigvd.amt.projectone.model;


import lombok.Builder;
import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.LinkedList;


@Builder
@Getter
public class Administrator extends Person{
    private LinkedList<Team> teams;
}
