package com.example.gururecipe.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

	public Ingredient(String string, BigDecimal bigDecimal, UnitOfMeasure tableSpoonUom, Recipe tacosRecipe) {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private BigDecimal amount;
	
	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure uom;
	
	@ManyToOne
	private Recipe recipe;
}
