package group.ship.blackshipstore.dto;

public class ItemResponseDTO {
    private String itemName;
    public ItemResponseDTO(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
