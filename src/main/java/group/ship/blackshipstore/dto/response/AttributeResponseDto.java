package group.ship.blackshipstore.dto.response;

import group.ship.blackshipstore.entity.Item;
import group.ship.blackshipstore.entity.Value;

import java.util.List;

public class AttributeResponseDto {

    private final Long id;

    private String name;

    private List<Item> items;

    private List<Value> values;

    public AttributeResponseDto(Long id) {
        this.id = id;
    }
}
