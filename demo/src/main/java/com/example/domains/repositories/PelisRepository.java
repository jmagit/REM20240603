package com.example.domains.repositories;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.domains.entities.Film;

@RepositoryRestResource(path="peliculas", itemResourceRel="pelicula", collectionResourceRel="peliculas")
public interface PelisRepository extends JpaRepository<Film, Integer> {
	@RestResource(path = "por-titulo")
	List<Film> findByTitleStartingWith(String empieza, Pageable page);
}
