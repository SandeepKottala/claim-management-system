package com.findit.user.serviceImpl;

import org.springframework.stereotype.Service;

import com.findit.user.dto.UserDTO;
import com.findit.user.entity.User;
import com.findit.user.exception.ResourceNotFoundException;
import com.findit.user.mapper.UserMapper;
import com.findit.user.service.UserService;
import com.findit.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{
	
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	public UserDTO createUser(UserDTO userDTO) {
		
		User user = UserMapper.toUserEntity(userDTO);
		User savedUser = userRepository.save(user);
		return UserMapper.toUserDTO(savedUser);
	}
	
	public UserDTO getUserByID(Long userId) {
		
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("ID not found"));
		return UserMapper.toUserDTO(user);
		
	}

}
