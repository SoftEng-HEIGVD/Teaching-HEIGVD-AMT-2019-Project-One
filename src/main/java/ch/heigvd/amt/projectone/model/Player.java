package ch.heigvd.amt.projectone.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class Player {

    private String nom;
    private String prenom;
    String position;
}
