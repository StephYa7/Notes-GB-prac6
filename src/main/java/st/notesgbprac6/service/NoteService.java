package st.notesgbprac6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import st.notesgbprac6.model.Note;
import st.notesgbprac6.repository.NoteRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NoteService {
    NoteRepository noteRepository;

    public Note saveNote(Note note) {
        note.setDateCreated(LocalDateTime.now());
        return noteRepository.save(note);
    }

    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }

    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    public Note updateNote(Long id, Note note) {
        Optional<Note> update = noteRepository.findById(id);
        if (update.isEmpty()) return null;
        update.get().setHeader(note.getHeader());
        update.get().setBody(note.getBody());
        update.get().setDateCreated(LocalDateTime.now());

        return noteRepository.save(update.get());
    }

    public Note deleteNoteById(Long id) {
        Optional<Note> deleteNote = noteRepository.findById(id);
        if (deleteNote.isEmpty()) return null;

        noteRepository.delete(deleteNote.get());

        return deleteNote.get();
    }
}