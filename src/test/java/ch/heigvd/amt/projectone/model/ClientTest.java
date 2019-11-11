package ch.heigvd.amt.projectone.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void itShouldHaveAConstructor() {
        Client client = Client.builder()
                .username("oliechti")
                .name("olivier")
                .password("xxxx")
                .isAdmin(true)
                .build();
        assertEquals("oliechti", client.getUsername());
        assertEquals("olivier", client.getName());
        assertEquals("xxxx", client.getPassword());
        assertEquals(true, client.isAdmin());
    }

}