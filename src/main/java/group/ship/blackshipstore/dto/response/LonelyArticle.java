package group.ship.blackshipstore.dto.response;

import java.util.ArrayList;
import java.util.List;

public class LonelyArticle {
    private long id;

    private int amount;

    private long price;

    private String itemName;

    private List<String> attributeNames;

    private List<String> valueNames;

    public LonelyArticle() {
        this.attributeNames = new ArrayList<>();
        this.valueNames = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void addToAttr(String e){
        if (e != null){
            attributeNames.add(e);
        }
    }

    public void addToVal(String e){
        if (e != null){
            valueNames.add(e);
        }
    }

    public List<String> getAttributeNames() {
        return attributeNames;
    }

    public void setAttributeNames(List<String> attributeNames) {
        this.attributeNames = attributeNames;
    }

    public List<String> getValueNames() {
        return valueNames;
    }

    public void setValueNames(List<String> valueNames) {
        this.valueNames = valueNames;
    }

    @Override
    public String toString() {
        return "LonelyArticle{" +
                "id=" + id +
                ", amount=" + amount +
                ", price=" + price +
                ", itemName='" + itemName + '\'' +
                ", attributeNames=" + attributeNames +
                ", valueNames=" + valueNames +
                '}';
    }
}
