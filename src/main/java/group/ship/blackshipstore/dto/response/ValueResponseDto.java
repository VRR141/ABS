package group.ship.blackshipstore.dto.response;

import group.ship.blackshipstore.entity.Attribute;

public class ValueResponseDto {

    private final Long id;

    private String name;

    private Attribute attribute;

    public ValueResponseDto(Long id) {
        this.id = id;
    }
}
