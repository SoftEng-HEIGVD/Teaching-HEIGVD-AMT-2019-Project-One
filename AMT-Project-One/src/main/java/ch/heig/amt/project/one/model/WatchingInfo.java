package ch.heig.amt.project.one.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Builder
@Getter
@Setter
@EqualsAndHashCode
public class WatchingInfo extends Entity {
    private int timeSpent;
    private Date beginningDate;
}
