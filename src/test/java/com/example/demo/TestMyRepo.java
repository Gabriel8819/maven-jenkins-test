package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestMyRepo {

	@Test
	public void GetUserMyRepo() {
		
		var repo = new MyRepo();
		var user = repo.getUser();
		var expected = "Charlie Unicorn";
		
		assertEquals(expected, user);
	}
	
	
	
}
