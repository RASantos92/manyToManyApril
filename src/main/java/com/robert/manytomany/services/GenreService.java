package com.robert.manytomany.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.robert.manytomany.models.Genre;
import com.robert.manytomany.repositories.GenreRepository;

@Service
public class GenreService {

	private final GenreRepository genreRepo;
	public GenreService(GenreRepository genreRepo) {
		this.genreRepo = genreRepo;
	}
	
	public Genre getOne(Long id) {
		Optional<Genre> genre = genreRepo.findById(id);
		return genre.isPresent() ? genre.get() : null;
	}

	public List<Genre> getAll() {
		return (List<Genre>) genreRepo.findAll();
	}

	public Genre create(Genre genre) {
		return genreRepo.save(genre);
	}

	public Genre update(Genre genre) {
		return genreRepo.save(genre);
	}

	public void delete(Long id) {
		genreRepo.deleteById(id);
	}


}
