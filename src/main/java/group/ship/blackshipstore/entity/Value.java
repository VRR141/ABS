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

@Entity
@Table(name = "values")
public class Value {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value_name" )
    private String valueName;

    @OneToMany(mappedBy = "value")
    List<ItemValues> itemValuesList;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "attribute_id",referencedColumnName = "id")
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
}
