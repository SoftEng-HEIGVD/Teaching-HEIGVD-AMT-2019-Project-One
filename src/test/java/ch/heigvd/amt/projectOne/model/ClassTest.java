package ch.heigvd.amt.projectOne.model;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class ClassTest {


    @Test
    void itShouldBePossibleToCreateClass() {


        Class myclass = Class.builder()
                .name("Thief").build();

        assertNotNull(myclass);
        assertEquals("Thief", myclass.getName());

    }

}