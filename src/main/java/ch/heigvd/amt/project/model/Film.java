package ch.heigvd.amt.project.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

// TODO: We'd have to handle images as DAO

@Builder
@Getter
@EqualsAndHashCode
public class Film {
    private int id;
    private String title;
    private int runningTime;
    private String moviePosterPath;
}
