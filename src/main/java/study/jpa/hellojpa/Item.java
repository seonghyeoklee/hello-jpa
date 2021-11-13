package study.jpa.hellojpa;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn
public class Item extends BaseEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int price;
}
