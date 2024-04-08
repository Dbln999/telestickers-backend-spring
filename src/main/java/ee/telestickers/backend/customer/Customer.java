package ee.telestickers.backend.customer;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ee.telestickers.backend.order.Order;
import ee.telestickers.backend.stickerpack.OrderRecord;
import ee.telestickers.backend.stickerpack.StickerPack;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(
        name = "customer"

)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @SequenceGenerator(
            name = "customer_id_seq",
            sequenceName = "customer_id_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "customer_id_seq"
    )
    private Long id;

    @Column(nullable = false)
    private Integer tgId;

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

    @Column(nullable = false)
    private Countries country;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer postcode;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<StickerPack> stickerPacks;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Order> orders;



    public Customer(Integer tgId, String firstname, String lastname, Countries country, String address, Integer postcode, String phoneNumber, String email, String city) {
        this.tgId = tgId;
        this.firstname = firstname;
        this.lastname = lastname;
        this.country = country;
        this.address = address;
        this.postcode = postcode;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.city = city;
    }

    public Customer(Long id){
        this.id = id;
    }


}
