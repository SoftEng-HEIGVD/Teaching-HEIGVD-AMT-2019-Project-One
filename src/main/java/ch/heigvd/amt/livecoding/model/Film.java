package ch.heigvd.amt.livecoding.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Film {
    private int id;
    private String title;
}
