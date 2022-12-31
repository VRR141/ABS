package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.entity.Item;
import group.ship.blackshipstore.repositories.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository repository;

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }
    public List<Item> findAll(){
        return repository.findAll();
    }

}
