package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

/*
Article contains Item price and total amount
 */
@Entity
@Table(name = "articles")
public class Article extends BaseEntity {
    /*
    Article id = Item id
     */
    @OneToOne
    @JoinColumn(name = "id", table = "item", referencedColumnName = "item_id")
    private Item itemId;

    /*
    Same Articles may be added to one Order many times
    */
    @ManyToMany(mappedBy = "articles")
    List<Order> orders;

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    private int amount;

    public Item getItemId() {
        return itemId;
    }

    public void setItemId(Item itemId) {
        this.itemId = itemId;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
