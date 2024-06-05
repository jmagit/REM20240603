package com.example.domains.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.example.domains.core.contracts.repositories.RepositoryWithProjections;
import com.example.domains.entities.Actor;
import com.example.domains.entities.models.ActorDTO;
import com.example.domains.entities.models.ActorShort;

public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor>, 
	RepositoryWithProjections {
	List<Actor> findTop5ByFirstNameStartingWithOrderByLastNameDesc(String prefijo);
	List<Actor> findTop5ByFirstNameStartingWith(String prefijo, Sort orderBy);
	
	List<Actor> findByActorIdGreaterThan(int inicial);
	@Query(value = "FROM Actor a WHERE a.actorId > ?1")
	List<Actor> findByJPA(int inicial);
	@Query(value = "select * from actor where actor_id > :inicial", nativeQuery = true)
	List<Actor> findBySQL(int inicial);

	List<ActorDTO> queryByActorIdGreaterThan(int inicial);
	List<ActorShort> readByActorIdGreaterThan(int inicial);
	<T> List<T> searchByActorIdGreaterThan(int inicial, Class<T> tipo);

	<T> List<T> findAllBy(Class<T> tipo);
	<T> List<T> findAllBy(Sort orden, Class<T> tipo);
	<T> Page<T> findAllBy(Pageable page, Class<T> tipo);

}
