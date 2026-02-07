package com.findit.user.service;

import com.findit.user.dto.UserDTO;

public interface UserService {
	
	UserDTO createUser(UserDTO userDTO);
	UserDTO getUserByID(Long userId);

}
