package group.ship.blackshipstore.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import java.util.Objects;
import org.hibernate.Hibernate;

@Entity
@Table(name = "values")
public class Value {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value_name")
    private String valueName;

    @OneToMany(mappedBy = "value")
    List<ItemValues> itemValuesList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id", referencedColumnName = "id")
    private Attribute attribute;

    public Value() {
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "valueName = " + valueName + ")";
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
        Value value = (Value) o;
        return id != null && Objects.equals(id, value.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
