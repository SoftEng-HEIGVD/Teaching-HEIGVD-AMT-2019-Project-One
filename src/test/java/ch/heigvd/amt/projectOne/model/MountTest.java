package ch.heigvd.amt.projectOne.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class MountTest {

    @Test
    void itShouldBePossibleToCreateMount(){

        Mount mount = Mount.builder().name("Tornado").speed(100).build();

        assertNotNull(mount);
        assertEquals("Tornado", mount.getName());
        assertEquals(100, mount.getSpeed());
    }
}