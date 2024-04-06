package ee.telestickers.backend.size;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import ee.telestickers.backend.order.Order;
import ee.telestickers.backend.sticker.Sticker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(
        name = "size"
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Size {
    @Id
    @SequenceGenerator(
            allocationSize = 1,
            sequenceName = "size_id_seq",
            name = "size_id_seq"
    )
    @GeneratedValue(strategy =  GenerationType.SEQUENCE, generator = "size_id_seq")
    private Long id;

    @Column(nullable = false)
    private StickerSize size;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonBackReference
    private Order order;

    @ManyToMany
    @JoinTable(name = "size_stickers",
            joinColumns = @JoinColumn(name = "size_id"),
            inverseJoinColumns = @JoinColumn(name = "sticker_id")
    )
    private List<Sticker> stickers;

    public Size (StickerSize size, Order order, List<Sticker> stickers) {
        this.size = size;
        this.order = order;
        this.stickers = stickers;
    }
}
