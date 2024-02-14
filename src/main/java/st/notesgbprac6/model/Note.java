package st.notesgbprac6.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "note")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(nullable = false, name = "headr")
    private String header;

    @Column(nullable = false, name = "body")
    private String body;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "date_created")
    private LocalDateTime dateCreated;
}