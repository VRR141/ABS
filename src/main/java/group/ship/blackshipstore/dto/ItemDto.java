package group.ship.blackshipstore.dto;

import java.util.UUID;

public class ItemDto {
    private final UUID uuid;
    private final UUID name;

    public ItemDto(UUID uuid, UUID name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public UUID getName() {
        return name;
    }
}
