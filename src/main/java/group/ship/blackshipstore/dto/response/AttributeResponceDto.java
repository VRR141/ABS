package group.ship.blackshipstore.dto.response;

import group.ship.blackshipstore.entity.Item;
import group.ship.blackshipstore.entity.Value;

import java.util.List;

public class AttributeResponceDto {

    private Long id;

    private String name;

    private List<Item> items;

    private List<Value> values;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }
}
