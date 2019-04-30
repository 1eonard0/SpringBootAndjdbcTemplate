package com.example.demo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.User;
import com.example.demo.repositories.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class JdbcTemplateWithSpringBootApplicationTests {

	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void findAllUser() {
		List<User> users = userRepository.findAll();
		assertNotNull(users);
		assertTrue(!users.isEmpty());
	}
	
	@Test    public void findUserById()  {        
		User user = userRepository.findUserById(1);        
		assertNotNull(user);    
	}
	
	@Test    public void createUser() {        
		User user = new User(0, "Johnson", "johnson@gmail.com");        
		User savedUser = userRepository.create(user);        
		User newUser = userRepository.findUserById(savedUser.getId());        
		assertNotNull(newUser);        
		assertEquals("Johnson", newUser.getName());        
		assertEquals("johnson@gmail.com", newUser.getEmail());    
	}

}
