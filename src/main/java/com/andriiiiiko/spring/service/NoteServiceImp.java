package com.andriiiiiko.spring.service;

import com.andriiiiiko.spring.entity.Note;
import com.andriiiiiko.spring.exception.NoteNotFoundException;
import com.andriiiiiko.spring.repository.NoteRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
@Slf4j
public class NoteServiceImp implements NoteService {

    private final NoteRepository noteRepository;

    @Override
    public Note createNote(Note note) {
        log.info("Adding a new note");
        return noteRepository.save(note);
    }

    @Override
    public Note getNoteById(Long noteId) {
        log.info("Getting note by ID: {}", noteId);
        return noteRepository
                .findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException(noteId));
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public void deleteNoteById(Long noteId) {
        log.info("Deleting note with ID: {}", noteId);
        noteRepository.deleteById(noteId);
    }

    @Override
    public Note updateNote(Long noteId, Note note) {
        Note noteDB = noteRepository
                .findById(noteId)
                .orElseThrow(() -> new NoteNotFoundException(noteId));

        if (Objects.nonNull(note.getTitle()) && !"".equalsIgnoreCase(note.getTitle())) {
            noteDB.setTitle(note.getTitle());
        }

        if (Objects.nonNull(note.getContent()) && !"".equalsIgnoreCase(note.getContent())) {
            noteDB.setContent(note.getContent());
        }

        log.info("Updating note with ID: {}", noteId);
        return noteRepository.save(noteDB);
    }
}
