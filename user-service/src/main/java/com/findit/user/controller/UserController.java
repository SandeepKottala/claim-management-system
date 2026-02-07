package com.findit.user.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.findit.user.dto.UserDTO;
import com.findit.user.service.UserService;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {
	
	private final UserService userService;
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
	}


	@PostMapping
	public ResponseEntity<UserDTO> createUser(
			@Valid
			@RequestBody 
			UserDTO userDTO) {
		
		log.info("Request received to create User");
		UserDTO userCreated = userService.createUser(userDTO);
		log.info("User created successfully!" + userCreated);
		
		return ResponseEntity
				.status(HttpStatus.CREATED)
				.body(userCreated);
		
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> getUserByID(@PathVariable Long userId) {
		
		UserDTO getUserById = userService.getUserByID(userId);
		
		return ResponseEntity.ok(getUserById);
		
	}
	
	

}
