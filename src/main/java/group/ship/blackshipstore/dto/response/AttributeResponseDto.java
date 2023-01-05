package group.ship.blackshipstore.dto.response;

import java.util.List;

public class AttributeResponseDto {

    private Long id;

    private String name;

    private List<ItemResponseDto> items;

    private List<ValueResponseDto> values;

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

    public List<ItemResponseDto> getItems() {
        return items;
    }

    public void setItems(List<ItemResponseDto> items) {
        this.items = items;
    }

    public List<ValueResponseDto> getValues() {
        return values;
    }

    public void setValues(List<ValueResponseDto> values) {
        this.values = values;
    }
}
