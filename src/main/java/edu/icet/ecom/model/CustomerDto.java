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
@Table(name = "customer")
public class CustomerDto {

    @Id
    @Column(length = 6, nullable = false)
    private String custID;

    @Column(length = 5)
    private String custTitle ;

    @Column(length = 30, nullable = false)
    private String custName ;

    private LocalDate dob;

    @Column(precision = 10, nullable = false)
    private double salary;

    @Column(length = 30)
    private String custAddress;

    @Column(length = 20)
    private String city;

    @Column(length = 30)
    private String province;

    @Column(length = 9)
    private String postalCode;
}
