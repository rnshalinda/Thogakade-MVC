package edu.icet.ecom.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {

    String custID;
    String custTitle ;
    String custName ;
    LocalDate dob;
    double salary;
    String custAddress;
    String city;
    String province;
    String postalCode;
}
