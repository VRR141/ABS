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


    public Article() {
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
