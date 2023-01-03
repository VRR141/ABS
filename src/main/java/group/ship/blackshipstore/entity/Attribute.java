package group.ship.blackshipstore.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.util.List;

/*
Attribute is: color, size, material, etc.
 */
@Entity
@Table(name = "attributes")
public class Attribute extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    @JdbcTypeCode(SqlTypes.BIGINT)
    private Long id;

    /*
    Each Attribute may belong to different Items
    Each Item has list of Attributes
    */
    @ManyToMany(mappedBy = "attributes")
    private List<Item> items;

    /*
    Each Attribute has list of Values: red, black, white, etc.
    */
    @OneToMany(mappedBy = "attribute")
    private List<Value> values;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public List<Value> getValues() {
        return values;
    }

    public void setValues(List<Value> values) {
        this.values = values;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
