package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.ItemDto;
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
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /*
    Mapping Item entity to ItemDto
     */
    private final Function<Item, ItemDto> itemDtoFunction = entity -> new ItemDto(
            entity.getName(),
            entity.getUuid()
    );

    public List<ItemDto> findAll() {
        return itemRepository.findAll().stream()
                .map(itemDtoFunction)
                .collect(Collectors.toList());
    }

    public List<ItemDto> findAllByCategoryId(Long categoryId) {
        return itemRepository.findAllByCategoryId(categoryId).stream()
                .map(itemDtoFunction)
                .collect(Collectors.toList());
    }
}
