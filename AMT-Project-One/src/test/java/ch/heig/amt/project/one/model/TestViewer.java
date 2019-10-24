package ch.heig.amt.project.one.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

public class TestViewer {
    @Test
    void itShouldBePossibleToCreateViewers() {
        Viewer viewer = Viewer.builder()
                .firstname("John")
                .lastname("Fitz")
                .username("fitz97")
                .birthDate(new Date(1997, 10, 5))
                .build();
        viewer.setId(1205);

        assertNotNull(viewer);
        assertEquals(1205, viewer.getId());
        assertEquals("John", viewer.getFirstname());
        assertEquals("Fitz", viewer.getLastname());
        assertEquals("fitz97", viewer.getUsername());
        assertEquals(new Date(1997, 10, 5), viewer.getBirthDate());
    }
}
