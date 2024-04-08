package ee.telestickers.backend.sticker;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sticker")
@Data
public class Sticker {
    @Id
    @SequenceGenerator(
            name = "sticker_id_seq",
            sequenceName = "sticker_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "sticker_id_seq"
    )
    private Long id;

    @Column(nullable = false)
    private String link;

    @Column(nullable = false)
    private String googleLink;



    public Sticker (String link, String googleLink) {
        this.link = link;
        this.googleLink = googleLink;
    }
}
