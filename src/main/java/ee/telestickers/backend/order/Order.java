package ee.telestickers.backend.order;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ee.telestickers.backend.customer.Customer;
import ee.telestickers.backend.size.Size;
import ee.telestickers.backend.stickerpack.StickerPack;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(
        name = "_order"
)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(
            name = "order_id_seq",
            sequenceName = "order_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "order_id_seq"
    )
    private Long id;

    @Column(nullable = false)
    private Long printfulId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    @JsonBackReference
    private Customer customer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "stickerpack_id", nullable = false)
    @JsonBackReference
    private StickerPack stickerPack;

    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY, orphanRemoval = true, cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Size> size;
    
    public Order (Customer customer, StickerPack stickerPack, Long printfulId) {
        this.customer = customer;
        this.stickerPack = stickerPack;
        this.printfulId = printfulId;
    }
}
