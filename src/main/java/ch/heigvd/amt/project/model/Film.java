package ch.heigvd.amt.project.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

// TODO: We'd have to handle images as DAO

@Builder(toBuilder = true)
@Getter
@EqualsAndHashCode
public class Film {
    private final long id;
    private final String title;
    private final int runningTime;
    private final String moviePosterPath;
    private final String director;
}
