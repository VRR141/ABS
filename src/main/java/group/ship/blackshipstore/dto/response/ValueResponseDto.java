package group.ship.blackshipstore.dto.response;

import group.ship.blackshipstore.entity.Attribute;

public class ValueResponseDto {

    private Long id;

    private String name;

    private Attribute attribute;

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

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
