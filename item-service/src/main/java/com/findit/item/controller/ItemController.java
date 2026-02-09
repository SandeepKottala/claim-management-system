package com.findit.item.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.findit.item.dto.ItemDTO;
import com.findit.item.pojo.CreateItemRequest;
import com.findit.item.service.ItemService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/items")
public class ItemController {
	
	private ItemService itemService;

	public ItemController(ItemService itemService) {
		
		this.itemService = itemService;
	}

	@PostMapping
	public ResponseEntity<ItemDTO> createItem(@RequestBody CreateItemRequest createItemRequest) {
		
		ItemDTO itemCreated = itemService.createItem(createItemRequest);
		
		/*return ResponseEntity
	            .status(HttpStatus.CREATED)
	            .body(itemCreated);*/
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(itemCreated);
		
	}
	
	@GetMapping("/{itemId}")
	public ResponseEntity<ItemDTO> getItemByID(
			@Valid
			@PathVariable 
			Long itemId) {
		
		ItemDTO itemByID = itemService.getItemByID(itemId);
		
		return ResponseEntity.ok(itemByID);
	}
	
	@GetMapping
	public ResponseEntity<List<ItemDTO>> getAllItems() {
		
		List<ItemDTO> itemDTO = itemService.getAllItems();
		
		return ResponseEntity.ok(itemDTO);
		
	}
 }
