package com.robert.manytomany.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.robert.manytomany.models.Genre;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
	List<Genre> findAll();
	
	Optional<Genre> findByName(String name);
}
