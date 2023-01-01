package group.ship.blackshipstore.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class ItemsValuesArticlesKey implements Serializable {

    @Column(name = "item_id")
    private Long itemsId;

    @Column(name = "value_id")
    private Long valuesId;


    public ItemsValuesArticlesKey() {
    }

    public ItemsValuesArticlesKey(Long itemsId, Long valuesId) {
        this.itemsId = itemsId;
        this.valuesId = valuesId;

    }

    public Long getItemsId() {
        return itemsId;
    }

    public void setItemsId(Long itemsId) {
        this.itemsId = itemsId;
    }

    public Long getValuesId() {
        return valuesId;
    }

    public void setValuesId(Long valuesId) {
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

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "itemsId = " + itemsId + ", " +
                "valuesId = " + valuesId + ")";
    }
}
