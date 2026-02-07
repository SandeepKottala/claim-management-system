package com.findit.user.mapper;

import com.findit.user.dto.UserDTO;
import com.findit.user.entity.User;

public class UserMapper {
	
	public static User toUserEntity(UserDTO userDTO) {
		
		User user = new User();
		
		user.setName(userDTO.getName());
		user.setRole(userDTO.getRole());
		user.setEmail(userDTO.getEmail());
		
		return user;
		
	}
	
	public static UserDTO toUserDTO(User user) {
		
		UserDTO userDTO = new UserDTO();
		userDTO.setUserId(user.getUserId());
		userDTO.setName(user.getName());
		userDTO.setRole(user.getRole());
		userDTO.setEmail(user.getEmail());
		
		return userDTO;
	}

}
