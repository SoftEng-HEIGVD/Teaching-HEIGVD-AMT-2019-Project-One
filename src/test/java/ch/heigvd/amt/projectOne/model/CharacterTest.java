package ch.heigvd.amt.projectOne.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {

  @Test
  void itShouldBePossibleToCreateCharacter() {
    Character tsimwi = Character.builder()
      .name("Tsimwi")
            .level(1)
            .health(100)
            .mana(100)
            .stamina(100)
            .mount(Mount.builder().name("Pegasus").speed(100).build())
            .myClass(Class.builder().name("Mage").build())
            .build();


      assertNotNull(tsimwi);
      assertEquals("Tsimwi", tsimwi.getName());
      assertEquals(1, tsimwi.getLevel());
      assertEquals(100, tsimwi.getHealth());
      assertEquals(100, tsimwi.getMana());
      assertEquals(100, tsimwi.getStamina());
      assertEquals("Pegasus", tsimwi.getMount().getName());
      assertEquals(100, tsimwi.getMount().getSpeed());
  }
}