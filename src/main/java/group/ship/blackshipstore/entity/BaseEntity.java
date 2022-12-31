package group.ship.blackshipstore.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class BaseEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
