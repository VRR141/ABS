package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "articles")
public class Article {

    @EmbeddedId
    @Column(name = "id")
    private ItemsValuesArticlesKey id;

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    private int amount;

    @ManyToOne
    @MapsId("itemsId")
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne
    @MapsId("valueId")
    @JoinColumn(name = "value_id")
    private Value value;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Article() {
    }

    public Article(ItemsValuesArticlesKey id, int price, int amount, Item item, Value value) {
        this.id = id;
        this.price = price;
        this.amount = amount;
        this.item = item;
        this.value = value;
    }

    public long getPrice() {
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
