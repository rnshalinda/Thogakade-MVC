package edu.icet.ecom.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Objects;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode  // this replaces equals & hashCode requirement
public class OrderDetailCompositeKey implements Serializable {

    private String orderID;
    private String itemCode;

//    // equals & hashCode are required!
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof OrderDetailCompositeKey)) return false;
//        OrderDetailCompositeKey that = (OrderDetailCompositeKey) o;
//        return Objects.equals(orderID, that.orderID) &&
//                Objects.equals(itemCode, that.itemCode);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(orderID, itemCode);
//    }

}
