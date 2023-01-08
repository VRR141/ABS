package group.ship.blackshipstore.dto.response;

import java.time.LocalDate;

public class OrderResponseDto {

    private Long id;

    private String pirateName;

    private String statusName;

    private LocalDate orderDate;

    private LocalDate completedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPirateName() {
        return pirateName;
    }

    public void setPirateName(String pirateName) {
        this.pirateName = pirateName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
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
