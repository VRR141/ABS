package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "status")
public class Status extends BaseEntity {
    @OneToMany
    @JoinColumn(name = "status_id")
    private List<Order> orders;

    @Column(name = "name")
    private String name;

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}