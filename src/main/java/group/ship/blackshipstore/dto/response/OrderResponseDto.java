package group.ship.blackshipstore.dto.response;

import group.ship.blackshipstore.entity.Status;

import java.time.LocalDate;

public class OrderResponseDto {
    private final Long id;
    private Status status;
    private LocalDate orderDate;
    private LocalDate completedDate;

    public OrderResponseDto(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
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
