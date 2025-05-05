package inventory.model;

import inventory.repository.InventoryRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    private Inventory inventory;
    private InventoryRepository repo;
    private Product product;
    private ObservableList<Part> partList = FXCollections.observableArrayList();;

    @BeforeEach
    void setUp() {
        try{
            repo = new InventoryRepository();
            inventory = repo.getInventory();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("Empty search item")
    void lookUpProduct_TC01() {
        assert inventory.lookupProduct("") == null;
    }

    @Test
    @DisplayName("Search item found")
    void lookUpProduct_TC02() {
        Assertions.assertEquals(inventory.lookupProduct("itemName").getProductId(), 1);
    }

    @Test
    @DisplayName("Search item not found")
    void lookUpProduct_TC03() {
        assertNull(inventory.lookupProduct("__does_not_exist__"));
    }

    @Test
    @DisplayName("Search in empty inventory returns null")
    void lookUpProduct_TC04() {
        inventory.getProducts().clear();

        Product result = inventory.lookupProduct("TEST");

        assertNull(result, "Expected lookupProduct to return null when inventory is empty");
    }





}