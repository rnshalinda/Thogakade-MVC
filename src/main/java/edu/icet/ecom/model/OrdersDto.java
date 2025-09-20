package edu.icet.ecom.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrdersDto {

    String OrderID;
    LocalDate OrderDate;
    String CustID;
}
