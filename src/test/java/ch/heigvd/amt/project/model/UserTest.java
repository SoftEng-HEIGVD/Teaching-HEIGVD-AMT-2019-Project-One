package ch.heigvd.amt.project.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

  @Test
  void itShouldBePossibleToCreateUsers() {
    User john = User.builder()
            .id(0)
            .firstName("John")
            .lastName("Doe")
            .email("John.Doe@email.com")
            .password("mypassword")
            .build();

    assertNotNull(john);
    assertEquals("John", john.getFirstName());
    assertEquals("Doe", john.getLastName());
    assertEquals("mypassword", john.getPassword());
    assertEquals("John.Doe@email.com", john.getEmail());

  }
}