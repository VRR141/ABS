package group.ship.blackshipstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemsValuesArticlesKey implements Serializable {

    @Column(name = "item_id")
    private int itemsId;

    @Column(name = "value_id")
    private int valuesId;


    public ItemsValuesArticlesKey() {
    }

    public ItemsValuesArticlesKey(int itemsId, int valuesId) {
        this.itemsId = itemsId;
        this.valuesId = valuesId;

    }

    public int getItemsId() {
        return itemsId;
    }

    public void setItemsId(int itemsId) {
        this.itemsId = itemsId;
    }

    public int getValuesId() {
        return valuesId;
    }

    public void setValuesId(int valuesId) {
        this.valuesId = valuesId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsValuesArticlesKey that = (ItemsValuesArticlesKey) o;
        return itemsId == that.itemsId && valuesId == that.valuesId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemsId, valuesId);
    }
}
