package com.findit.item.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UserClient {
	
	RestTemplate restTemplete;

	public UserClient(RestTemplate restTemplete) {
		super();
		this.restTemplete = restTemplete;
	}
	
	public boolean userExists(Long userId) {
		
		try {
		restTemplete.getForObject("http://localhost:8081/api/users/" + userId, Object.class);
		return true;
		}catch(Exception e) {
			return false;
		}
	}

}
