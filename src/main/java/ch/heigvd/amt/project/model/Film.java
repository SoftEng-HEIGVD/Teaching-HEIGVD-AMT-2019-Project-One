package ch.heigvd.amt.project.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

// TODO: We'd have to handle images as DAO

@Builder
@Getter
@EqualsAndHashCode
public class Film {
    private final int id;
    private final String title;
    private final int runningTime;
    private final String moviePosterPath;
}
