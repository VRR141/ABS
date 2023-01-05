package group.ship.blackshipstore.dto.response;

public class ValueResponseDto {

    private Long id;

    private String name;

    private AttributeResponseDto attribute;

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

    public AttributeResponseDto getAttribute() {
        return attribute;
    }

    public void setAttribute(AttributeResponseDto attribute) {
        this.attribute = attribute;
    }
}
