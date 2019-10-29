package ch.heigvd.amt.projectOne.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Class {

    private int id;
    private String name;
    private String weapon;
    private String armor;
    private String description;

}
