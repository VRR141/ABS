package group.ship.blackshipstore.dto.response;

import jakarta.persistence.Column;

import java.util.List;

public class ArticleResponseDto {

    private long id;

    private List<ItemResponseDto> itemResponseDtoList;

    private int price;

    private int amount;

    public List<ItemResponseDto> getItemResponseDtoList() {
        return itemResponseDtoList;
    }

    public void setItemResponseDtoList(List<ItemResponseDto> itemResponseDtoList) {
        this.itemResponseDtoList = itemResponseDtoList;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
