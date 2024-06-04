package com.example.domains.repositories;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import com.example.domains.entities.Actor;

public interface ActorRepository extends JpaRepository<Actor, Integer>, JpaSpecificationExecutor<Actor> {
	List<Actor> findTop5ByFirstNameStartingWithOrderByLastNameDesc(String prefijo);
	List<Actor> findTop5ByFirstNameStartingWith(String prefijo, Sort orderBy);
	
	List<Actor> findByActorIdGreaterThan(int inicial);
	@Query(value = "FROM Actor a WHERE a.actorId > ?1")
	List<Actor> findByJPA(int inicial);
	@Query(value = "select * from actor where actor_id > :inicial", nativeQuery = true)
	List<Actor> findBySQL(int inicial);
	
}
