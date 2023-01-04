package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

/*
Order is a list of Articles
Each Article may be added to orders many times
Each Pirate can make as many Orders as he likes
 */
@Entity
@Table(name = "orders")
public class Order extends BaseEntity {

    @ManyToOne(targetEntity = Pirate.class)
    private Pirate pirate;

    @ManyToOne(targetEntity = Status.class)
    private Status status;

    @ManyToMany(targetEntity = Article.class)
    @JoinTable(
            name = "orders_articles",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "article_id"))
    private List<Article> articles;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "completed_date")
    private LocalDate completedDate;

    public Pirate getPirate() {
        return pirate;
    }

    public void setPirate(Pirate pirate) {
        this.pirate = pirate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
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
