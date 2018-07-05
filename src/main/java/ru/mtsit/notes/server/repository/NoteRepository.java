package ru.mtsit.notes.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.mtsit.notes.server.entity.Note;

public interface NoteRepository extends JpaRepository <Note, Long> {
}
