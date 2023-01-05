package group.ship.blackshipstore.dto.response;

import group.ship.blackshipstore.entity.Attribute;
import group.ship.blackshipstore.entity.Category;

import java.util.List;

public class ItemResponseDto {

    private final Long id;

    private String name;

    private List<Attribute> attributes;

    private Category category;

    public ItemResponseDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
