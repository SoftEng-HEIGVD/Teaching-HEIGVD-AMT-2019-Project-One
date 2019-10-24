package ch.heigvd.amt.projectOne.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Mount {

    private int id;
    private String name;
    private int speed;

    public Mount(int id, String name, int speed) {
        this.id = id;
        this.name = name;
        this.speed = speed;
    }
}
