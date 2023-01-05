package group.ship.blackshipstore.dto.response;

import group.ship.blackshipstore.entity.Item;

import java.util.List;

public class CategoryResponseDto {

    private final Long id;

    private List<Item> items;

    private String name;

    public CategoryResponseDto(Long id) {
        this.id = id;
    }
}
