package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

/*
Item is: Captains Hat, Shirt, Boots, etc.
 */
@Entity
@Table(name = "items")
public class Item extends BaseEntity {

    @Column(name = "name")
    private String name;

    /*
    Each Attribute has list of Values
    */
    @ManyToMany(targetEntity = Attribute.class)
    @JoinTable(
            name = "factory",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    private List<Attribute> attributes;

    /*
    Category is: Headwear, Clothes, Shoes, etc.
     */
    @ManyToOne(targetEntity = Category.class)
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
