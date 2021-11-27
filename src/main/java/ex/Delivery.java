package ex;

import javax.persistence.*;

@Entity
public class Delivery {

    @Id @GeneratedValue
    @Column(name = "DELIVERY_ID")
    private Long id;

    @OneToOne(mappedBy = "delivery", fetch = FetchType.LAZY)
    private Order order;
    private String city;
    private String street;
    private String zipCode;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus deliveryStatus;
}
