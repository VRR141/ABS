package group.ship.blackshipstore.dto;

import group.ship.blackshipstore.entity.Status;

import java.time.LocalDate;
import java.util.UUID;

public class OrderDto {
    private final UUID uuid;

    private Status status;
    private LocalDate orderDate;
    private LocalDate completedDate;

    public OrderDto(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public LocalDate getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(LocalDate completedDate) {
        this.completedDate = completedDate;
    }
}
