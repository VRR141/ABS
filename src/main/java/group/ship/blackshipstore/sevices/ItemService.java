package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.ItemResponceDTO;
import group.ship.blackshipstore.entity.Item;
import group.ship.blackshipstore.repositories.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ItemService {
    private final Repository repository;
    private final Function<Item, ItemResponceDTO> itemToItemResponceDTO = entity -> new ItemResponceDTO(
            entity.getItemName()
    );

    public ItemService(Repository repository) {
        this.repository = repository;
    }
    public List<ItemResponceDTO> findAll(){
        return repository.findAll().stream()
                .map(itemToItemResponceDTO)
                .collect(Collectors.toList());
    }
}
