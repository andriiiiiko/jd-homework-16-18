package com.andriiiiiko.spring.service;

import com.andriiiiiko.spring.entity.Note;

import java.util.List;

public interface NoteService {

    Note createNote(Note note);

    Note getNoteById(Long noteId);

    List<Note> getAllNotes();

    Note updateNote(Long noteId, Note note);

    void deleteNoteById(Long noteId);
}
