package group.ship.blackshipstore.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;
import java.util.Objects;
import org.hibernate.Hibernate;

@Entity
@Table(name = "item_values")
public class ItemValues {

    @EmbeddedId
    @Column(name = "id")
    private ItemsValuesArticlesKey id;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("itemsId")
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("valueId")
    @JoinColumn(name = "value_id")
    private Value value;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "article_id",referencedColumnName = "id")
    private Article article;


    public ItemValues() {
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "EmbeddedId = " + id + ")";
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
        ItemValues that = (ItemValues) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
