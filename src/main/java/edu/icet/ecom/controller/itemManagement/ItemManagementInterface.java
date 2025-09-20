package edu.icet.ecom.controller.itemManagement;

import edu.icet.ecom.model.ItemDto;
import javafx.collections.ObservableList;

import java.sql.SQLException;

public interface ItemManagementInterface {

    ObservableList<ItemDto> getTblData();

    void addItem(ItemDto itemDto);
}
