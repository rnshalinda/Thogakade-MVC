package edu.icet.ecom.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderDetailDto {

    String orderID;
    String itemCode;
    int orderQTY;
    double discount;
    //double total;
}
