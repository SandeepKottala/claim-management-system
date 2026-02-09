package com.findit.item.service;

import java.util.List;

import com.findit.item.dto.ItemDTO;
import com.findit.item.pojo.CreateItemRequest;

public interface ItemService {
	
	ItemDTO createItem(CreateItemRequest createItemRequest);
	ItemDTO getItemByID(Long itemId);
	List<ItemDTO> getAllItems();


}
