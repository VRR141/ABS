package group.ship.blackshipstore.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;
import org.hibernate.Hibernate;

@Entity
@Table(name = "articles")
public class Article {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "article")
    private List<ArticleOrder> articleOrderList;

    public Article() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "price = " + price + ", " +
                "amount = " + amount + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(
                o)) {
            return false;
        }
        Article article = (Article) o;
        return id != null && Objects.equals(id, article.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
