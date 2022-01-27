package com.example.gururecipe;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.gururecipe.domain.UnitOfMeasure;
import com.example.gururecipe.repositories.UnitOfMeasureRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UnitOfMeasureIntegrationTest {
	
	@Autowired
	UnitOfMeasureRepository uomRepository;
	
	@BeforeEach
	public void setUp() throws Exception {
		
	}
	
	@Test
	public void findByDescription() throws Exception {
		
		Optional<UnitOfMeasure> optional = uomRepository.findByDescription("Teaspoon");
		assertEquals("Teaspoon", optional.get().getDescription());
	}

}
