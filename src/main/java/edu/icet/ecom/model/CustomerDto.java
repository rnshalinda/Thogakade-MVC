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
    String custID;

    @Column(length = 5)
    String custTitle ;

    @Column(length = 30, nullable = false)
    String custName ;

    LocalDate dob;

    @Column(precision = 10, nullable = false)
    double salary;

    @Column(length = 30)
    String custAddress;

    @Column(length = 20)
    String city;

    @Column(length = 30)
    String province;

    @Column(length = 9)
    String postalCode;
}
