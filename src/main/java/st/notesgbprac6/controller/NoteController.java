package st.notesgbprac6.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import st.notesgbprac6.model.Note;
import st.notesgbprac6.service.NoteService;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/notes")
public class NoteController {
    NoteService noteService;

    @PostMapping
    public ResponseEntity<Note> saveNote(@RequestBody Note note) {

        Note newNote = noteService.saveNote(note);

        if (newNote == null) return ResponseEntity.badRequest().build();

        return ResponseEntity.ok(newNote);
    }

    @GetMapping
    public ResponseEntity<List<Note>> findAllNotes() {
        List<Note> notes = noteService.findAllNotes();
        if (notes.isEmpty()) return ResponseEntity.notFound().build();

        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Note> getNoteById(@PathVariable Long id) {
        Optional<Note> note = noteService.getNoteById(id);

        return note.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());

    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateNote(@PathVariable Long id, @RequestBody Note note) {
        Note updateNote = noteService.updateNote(id, note);
        if (updateNote == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNoteById(@PathVariable Long id) {
        Note deleteNote = noteService.deleteNoteById(id);
        if (deleteNote == null) return ResponseEntity.notFound().build();

        return ResponseEntity.ok().build();
    }
}