package ch.heigvd.amt.livecoding.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class Rating {
    private int user_id;
    private int film_id;
    private float rating;
}
