package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "order_date")
    private Date orderDate;

    @Column(name = "completed_date")
    private Date complitedDate;

    public Order() {
    }
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "order")
    private List<ArticleOrder> articleOrderList;

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getComplitedDate() {
        return complitedDate;
    }

    public void setComplitedDate(Date complitedDate) {
        this.complitedDate = complitedDate;
    }


}
