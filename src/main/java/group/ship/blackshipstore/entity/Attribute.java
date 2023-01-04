package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

/*
Attribute is: Color, Size, Material, etc.
 */
@Entity
@Table(name = "attributes")
public class Attribute extends BaseEntity {

    @Column(name = "name")
    private String name;

    @ManyToMany(mappedBy = "attributes")
    private List<Item> items;

    /*
    Value is: Red, Black, White, etc.
    */
    @OneToMany(mappedBy = "attribute")
    private List<Value> values;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
