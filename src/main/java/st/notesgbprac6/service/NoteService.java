package st.notesgbprac6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import st.notesgbprac6.model.Note;
import st.notesgbprac6.repository.NoteRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class NoteService {
    NoteRepository noteRepository;

    public Note saveNote(Note note) {
    }

    public List<Note> findAllNotes() {
    }

    public Note getNoteById(Long id) {
    }

    public Note updateNote(Long id, Note note) {
    }

    public Note deleteNoteById(Long id) {
    }
}