package group.ship.blackshipstore.dto.response;

import group.ship.blackshipstore.entity.Item;

import java.util.List;

public class CategoryResponseDto {

    private Long id;

    private List<Item> items;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
