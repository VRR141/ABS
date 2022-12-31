package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.entity.Item;
import group.ship.blackshipstore.repositories.Repository;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ItemService {
    private final Repository repository;

    public ItemService(Repository repository) {
        this.repository = repository;
    }
    public List<Item> findAll(){
        return repository.findAll();
    }

}
