package group.ship.blackshipstore.entity;

import jakarta.persistence.*;

import java.util.List;

/*
Item is: Треуголка, Бандана, Рубашка
 */
@Entity
@Table(name = "items")
public class Item extends BaseEntity {
    // TODO: Item id = Article id
    /*
    Each Item has unique Article,
    Item id = Article id
     */
    @Id
    @JoinColumn(name = "id", table = "article")
    private Long id;

    // TODO: Rename column "item_name" to "name"
    @Column(name = "item_name")
    private String name;

    /*
    Each Item has unique Category
     */
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private Category category;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
