package com.findit.item.mapper;

import java.util.List;

import com.findit.item.dto.ItemDTO;

import com.findit.item.entity.Item;


public class ItemMapper {
	
	public static Item toItemEntity(ItemDTO itemDTO) {
		
		Item item = new Item();
		
		item.setItemName(itemDTO.getItemName());
		item.setDescription(itemDTO.getDescription());
		item.setStatus(itemDTO.getStatus());
		item.setLocation(itemDTO.getLocation());
		item.setReportedAt(itemDTO.getReportedAt());
		item.setReportedByUserId(itemDTO.getReportedByUserId());
		
		return item;
	}
	
	public static ItemDTO toItemDTO(Item item) {
		
		ItemDTO itemDTO = new ItemDTO();
		
		itemDTO.setItemId(item.getItemId());
		itemDTO.setItemName(item.getItemName());
		itemDTO.setDescription(item.getDescription());
		itemDTO.setStatus(item.getStatus());
		itemDTO.setLocation(item.getLocation());
		itemDTO.setReportedAt(item.getReportedAt());
		
	
		
		itemDTO.setReportedByUserId(item.getReportedByUserId());
		
		return itemDTO;
		
	}
	
	  public static List<ItemDTO> toItemDTOList(List<Item> items) {
	        return items.stream()
	                    .map(ItemMapper::toItemDTO)
	                    .toList();
	  }
	
	

}
