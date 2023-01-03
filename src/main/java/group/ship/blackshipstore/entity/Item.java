package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

/*
Item is: Треуголка, Бандана, Рубашка
 */
@Entity
@Table(name = "items")
public class Item extends BaseEntity {
// TODO: Rename column "item_name" to "name"
    @Column(name = "name")
    private Long name;

    /*
    Each Item has list of Attributes
    Each Attribute may belong to different Items
    Each Attribute has list of Values
    */
    @ManyToMany(mappedBy = "items")
    @JoinTable(
            name = "item_attributes",
            joinColumns = @JoinColumn(name = "item_id"),
            inverseJoinColumns = @JoinColumn(name = "attribute_id"))
    List<Attribute> attributes;

    /*
    Each Item has unique Category
     */
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
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
