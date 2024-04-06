package ee.telestickers.backend.stickerpack;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ee.telestickers.backend.customer.Customer;
import ee.telestickers.backend.order.Order;
import ee.telestickers.backend.sticker.Sticker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(
        name = "stickerpack"
)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class StickerPack {

    @Id
    @SequenceGenerator(
            name = "stickerpack_id_seq",
            sequenceName = "stickerpack_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stickerpack_id_seq"
    )
    private Long id;

    @ManyToMany
    @JoinTable(name = "stickerpack_stickers",
            joinColumns = @JoinColumn(name = "stickerpack_id"),
            inverseJoinColumns = @JoinColumn(name = "sticker_id")
    )
    @JsonIgnore
    private List<Sticker> stickers;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference
    private Customer customer;

    @OneToOne(mappedBy = "stickerPack")
    @JsonManagedReference
    private Order order;
}
