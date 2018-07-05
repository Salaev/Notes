package ru.mtsit.notes.server.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private long id;

    @Column(name = "title", nullable = false, length = 50)
    private String title;

   @Column(name = "note_data", nullable = false)
   @Temporal(TemporalType.TIMESTAMP)
    private Date noteData;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getNoteData() {
        return noteData;
    }

    public void setNoteData(Date noteData) {
        this.noteData = noteData;
    }
}
