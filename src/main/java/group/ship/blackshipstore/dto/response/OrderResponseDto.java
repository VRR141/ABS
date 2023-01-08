package group.ship.blackshipstore.dto.response;

import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.Status;

import java.time.LocalDate;
import java.util.List;

public class OrderResponseDto {

    private Long id;

    private PirateResponseDto pirate;

    private Status status;

    private LocalDate orderDate;

    private LocalDate completedDate;

    private List<ArticleResponseDto> articleList;

    public List<ArticleResponseDto> getArticleList() {
        return articleList;
    }

    public void setArticleList(List<ArticleResponseDto> articleList) {
        this.articleList = articleList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PirateResponseDto getPirate() {
        return pirate;
    }

    public void setPirate(PirateResponseDto pirate) {
        this.pirate = pirate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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
