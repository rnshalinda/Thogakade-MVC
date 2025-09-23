package edu.icet.ecom.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "orderdetail")
@IdClass(OrderDetailCompositeKey.class)     // tells Hibernate this entity uses a composite key

public class OrderDetailDto {

    @Id
    @Column(length = 6, nullable = false)
    private String orderID;

    @Id
    @Column(length = 6, nullable = false)
    private String itemCode;

    @Column(nullable = false)
    private int orderQTY;

    @Column(precision = 3)
    private double discount;

}
