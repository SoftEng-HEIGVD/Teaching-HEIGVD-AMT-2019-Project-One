package ch.heigvd.amt.projectone.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    @Test
    void itShouldHaveAConstructor(){
        Client client = Client.builder()
                .name("olivier")
                .username("oliechti")
                .password("xxxx")
                .build();
        assertEquals("olivier", client.getName());
        assertEquals("oliechti", client.getUsername());
        assertEquals("xxxx", client.getPassword());
        assertEquals(false, client.isAdmin());
    }

}