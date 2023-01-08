package group.ship.blackshipstore.dto.response;


import java.time.LocalDate;
import java.util.List;

public class OrderResponseDto {

    private Long id;

    private String pirateName;

    private String statusName;

    private List<Long> articleId;

    private List<String> articleName;

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

    public String getPirateName() {
        return pirateName;
    }

    public void setPirateName(String pirateName) {
        this.pirateName = pirateName;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public List<Long> getArticleId() {
        return articleId;
    }

    public void setArticleId(List<Long> articleId) {
        this.articleId = articleId;
    }

    public List<String> getArticleName() {
        return articleName;
    }

    public void setArticleName(List<String> articleName) {
        this.articleName = articleName;
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
