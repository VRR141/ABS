package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "price")
    private int price;

    @Column(name = "amount")
    private int amount;

    public List<ItemValues> getItemValuesList() {
        return itemValuesList;
    }

    public void setItemValuesList(List<ItemValues> itemValuesList) {
        this.itemValuesList = itemValuesList;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private List<ItemValues> itemValuesList;

    public Article() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
