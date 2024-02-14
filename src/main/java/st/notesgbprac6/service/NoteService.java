package st.notesgbprac6.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import st.notesgbprac6.repository.NoteRepository;

@Service
@AllArgsConstructor
public class NoteService {
    NoteRepository noteRepository;
}