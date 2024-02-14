package st.notesgbprac6.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import st.notesgbprac6.service.NoteService;

@Controller
@AllArgsConstructor
public class NoteController {
    NoteService noteService;
}