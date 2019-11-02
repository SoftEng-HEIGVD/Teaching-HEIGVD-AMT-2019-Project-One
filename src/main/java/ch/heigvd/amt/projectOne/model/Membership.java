package ch.heigvd.amt.projectOne.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Membership {

    private int id;
    private Character character;
    private Guild guild;
    private String rank;

}
