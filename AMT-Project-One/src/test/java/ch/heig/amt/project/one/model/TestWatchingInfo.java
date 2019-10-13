package ch.heig.amt.project.one.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

public class TestWatchingInfo {
    @Test
    void itShouldBePossibleToCreateWatchingInfos() {
        WatchingInfo watchingInfo = WatchingInfo.builder()
                .beginningDate(new Date())
                .timeSpent(1789)
                .build();
        watchingInfo.setId(7896);

        assertNotNull(watchingInfo);
        assertEquals(7896, watchingInfo.getId());
        assertEquals(new Date(), watchingInfo.getBeginningDate());
        assertEquals(1789, watchingInfo.getTimeSpent());
    }
}
