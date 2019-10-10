package ch.heig.amt.project.one.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class WatchingInfo extends Entity {
    private int timeSpent;
    private Date beginningDate;
}
