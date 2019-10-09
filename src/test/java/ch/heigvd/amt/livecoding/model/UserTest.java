package ch.heigvd.amt.livecoding.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

  @Test
  void itShouldBePossibleToCreateUsers() {
    User oliechti = User.builder()
      .firstName("Olivier")
      .lastName("Liechti")
      .userName("oliechti")
      .build();
    assertNotNull(oliechti);
    assertEquals("Olivier", oliechti.getFirstName());
  }
}