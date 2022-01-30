package com.example.gururecipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.gururecipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>  {

	Category findByDescription(String description);
}
