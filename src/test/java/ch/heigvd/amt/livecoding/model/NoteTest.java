package ch.heigvd.amt.livecoding.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

  @Test
  void itShouldBePossibleToCreateNotes() {
    User oliechti = User.builder()
      .userName("oliechti")
      .build();
    Note note = Note.builder()
      .title("Note 1")
      .text("Bla bla")
      .author(oliechti)
      .build();

    assertEquals(oliechti, note.getAuthor());
  }
}