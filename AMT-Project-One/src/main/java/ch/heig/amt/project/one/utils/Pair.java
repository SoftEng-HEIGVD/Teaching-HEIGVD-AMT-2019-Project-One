package ch.heig.amt.project.one.utils;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Pair<L,R> {
    private L key;
    private R value;

    public Pair(L key, R value) {
        this.key = key;
        this.value = value;
    }
}
