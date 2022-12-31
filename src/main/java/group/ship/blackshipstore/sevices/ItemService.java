package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.ItemResponseDTO;
import group.ship.blackshipstore.entity.Item;
import group.ship.blackshipstore.repositories.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ItemService {
    private final ItemRepository repository;
    private final Function<Item, ItemResponseDTO> itemToItemResponseDTO = entity -> new ItemResponseDTO(
            entity.getItemName()
    );

    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    public List<ItemResponseDTO> findAll() {
        return repository.findAll().stream()
                .map(itemToItemResponseDTO)
                .collect(Collectors.toList());
    }
}
