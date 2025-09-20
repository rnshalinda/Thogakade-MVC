package edu.icet.ecom.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ItemDto {
    String itemCode;
    String description;
    String packSize;
    double unitPrice;
    int qtyOnHand;

}
