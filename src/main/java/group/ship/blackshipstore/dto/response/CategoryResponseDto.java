package group.ship.blackshipstore.dto.response;

import java.util.List;

public class CategoryResponseDto {

    private Long id;

    private List<ItemResponseDto> items;

    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ItemResponseDto> getItems() {
        return items;
    }

    public void setItems(List<ItemResponseDto> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
