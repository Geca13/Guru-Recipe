package com.example.gururecipe.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@EqualsAndHashCode(exclude = {"recipe"})
@Entity
@Data
@NoArgsConstructor
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private BigDecimal amount;

	
	@ManyToOne
	private Recipe recipe;
	
	public Ingredient(String description, BigDecimal amount, Recipe recipe) {
		super();
		this.description = description;
		this.amount = amount;
		this.recipe = recipe;
	}

	public Ingredient(String description, BigDecimal amount) {
        this.description = description;
        this.amount = amount;
        
    }

	
}
