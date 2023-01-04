package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

/*
Article contains Item price and total amount
 */
@Entity
@Table(name = "articles")
public class Article extends BaseEntity {

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    private int amount;

    /*
    Each unique Article contains list of entries Item-Attribute-Value:
    Bandana-Color-Red, Bandana-Size-L, Bandana-Material-Cotton
    */
    @OneToMany(targetEntity = Item.class)
    @JoinTable(
            name = "factory",
            joinColumns = @JoinColumn(name = "article_id"),
            inverseJoinColumns = @JoinColumn(name = "item_id"))
    private List<Item> items;

    /*
    One Article may be added to one Order many times
    Article may be added to many Orders
    */
    @ManyToMany(mappedBy = "articles")
    private List<Order> orders;

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

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}