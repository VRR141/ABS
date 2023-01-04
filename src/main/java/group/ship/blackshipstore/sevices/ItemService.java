package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.response.ItemResponseDto;
import group.ship.blackshipstore.entity.Item;
import group.ship.blackshipstore.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    /*
    Mapping Item entity to ItemDto
     */
    private final Function<Item, ItemResponseDto> itemDtoFunction = entity -> new ItemResponseDto(entity.getName());

    public List<ItemResponseDto> findAll() {
        return itemRepository.findAll().stream()
                .map(itemDtoFunction)
                .collect(Collectors.toList());
    }

    public List<ItemResponseDto> findAllByCategoryId(Long categoryId) {
        return itemRepository.findAllByCategoryId(categoryId).stream()
                .map(itemDtoFunction)
                .collect(Collectors.toList());
    }

    public ItemResponseDto findById(Long id) {
        return itemRepository.findById(id).map(itemDtoFunction).orElse(null);
    }
}
