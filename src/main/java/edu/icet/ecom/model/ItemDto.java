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
@Table(name = "item")
public class ItemDto {

    @Id
    @Column(length = 6, nullable = false)
    private String itemCode;

    @Column(length = 50, nullable = false)
    private String description;

    @Column(length = 20, nullable = true)
    private String packSize;

    @Column(precision = 10, nullable = false)
    private double unitPrice;

    @Column(nullable = false)
    private int qtyOnHand;
}
