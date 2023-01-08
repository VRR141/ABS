package group.ship.blackshipstore.dto.response;


import java.time.LocalDate;
import java.util.List;

public class OrderResponseDto {

    private Long id;

    private String pirateName;

    private String statusName;

    private List<String> attributeName;

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

    public List<String> getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(List<String> attributeName) {
        this.attributeName = attributeName;
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
