package edu.icet.ecom.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "orderdetail")
public class OrderDetailDto {

    @Id
    @Column(length = 6, nullable = false)
    String orderID;

    @Column(length = 6, nullable = false)
    String itemCode;

    @Column(nullable = false)
    int orderQTY;

    @Column(precision = 3)
    double discount;
    //double total;
}
