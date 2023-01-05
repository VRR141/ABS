package group.ship.blackshipstore.dto.response;

import java.util.List;

public class ItemResponseDto {

    private Long id;

    private String name;

    private List<AttributeResponseDto> attributes;

    private CategoryResponseDto category;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AttributeResponseDto> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeResponseDto> attributes) {
        this.attributes = attributes;
    }

    public CategoryResponseDto getCategory() {
        return category;
    }

    public void setCategory(CategoryResponseDto category) {
        this.category = category;
    }
}
