package com.findit.item.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.findit.item.client.UserClient;
import com.findit.item.dto.ItemDTO;
import com.findit.item.entity.Item;

import com.findit.item.exception.ResourceNotFoundException;
import com.findit.item.mapper.ItemMapper;
import com.findit.item.pojo.CreateItemRequest;
import com.findit.item.repository.ItemRepository;

import com.findit.item.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService{
	
	private ItemRepository itemRepository;
	private UserClient userClient;
	
	
	public ItemServiceImpl(ItemRepository itemRepository, UserClient userClient) {
		super();
		this.itemRepository = itemRepository;
		this.userClient = userClient;
		
	}

	public ItemDTO createItem(CreateItemRequest createItemRequest) {
		
		if(!userClient.userExists(createItemRequest.getReportedByUserId())) {
			
			throw new ResourceNotFoundException("User not found");
		}
		
		
		Item item = new Item();
		item.setItemName(createItemRequest.getItemName());
		item.setDescription(createItemRequest.getDescription());
		item.setStatus(createItemRequest.getStatus());
		item.setLocation(createItemRequest.getLocation());
		item.setReportedByUserId(createItemRequest.getReportedByUserId());
				
		return ItemMapper.toItemDTO(itemRepository.save(item));
	}
	
	public ItemDTO getItemByID(Long itemId) {
		
		Item itemByID = itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found"));
		return ItemMapper.toItemDTO(itemByID);		
	}	
	
	public List<ItemDTO> getAllItems() {
		
		List<Item> allItems = itemRepository.findAll();
		
		return ItemMapper.toItemDTOList(allItems);
		
	}

}


