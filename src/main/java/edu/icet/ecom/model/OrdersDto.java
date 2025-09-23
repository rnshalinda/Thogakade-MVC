package edu.icet.ecom.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

@Entity
@Table(name = "orders")
public class OrdersDto {

    @Id
    @Column(length = 6, nullable = false)
    private String OrderID;

    private LocalDate OrderDate;

    @Column(length = 6, nullable = false)
    private String CustID;
}
