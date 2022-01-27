package com.example.gururecipe;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.gururecipe.domain.Category;

public class CategoryTest {

	Category category;
	
	@BeforeEach
	public void setup() {
		category = new Category();
	}
	
	@Test
	public void getId() throws Exception {
		Long id = 4L;
		category.setId(id);
		assertEquals(id, category.getId());
	}
	
	@Test
	public void getDescription() throws Exception {
		String description = "cake";
		category.setDescription(description);
		assertEquals(description, category.getDescription());
	}
	
	@Test
	public void getRecipes() throws Exception {
		
	}
	
}
