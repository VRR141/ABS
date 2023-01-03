package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

/*
Article contains Item price and total amount
 */
@Entity
@Table(name = "articles")
public class Article extends BaseEntity {
    // TODO: Article id = Item id
    @OneToOne
    @JoinColumn(name = "id", table = "item", referencedColumnName = "item_id")
    private Item itemId;

    /*
    Same Articles may be added to one Order many times
    */
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    @OneToOne(mappedBy = "id")
    private Item item;

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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
