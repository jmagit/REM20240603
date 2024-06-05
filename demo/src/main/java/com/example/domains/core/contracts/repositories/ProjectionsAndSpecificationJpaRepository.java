package com.example.domains.core.contracts.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface ProjectionsAndSpecificationJpaRepository<E, ID> 
	extends JpaRepository<E, ID>, JpaSpecificationExecutor<E> {
	<T> List<T> findAllBy(Class<T> tipo);
	<T> List<T> findAllBy(Sort orden, Class<T> tipo);
	<T> Page<T> findAllBy(Pageable page, Class<T> tipo);
//	<T> Optional<T> findOne(Specification<E> spec, Class<T> tipo);
//	<T> List<T> findAll(Specification<E> spec, Class<T> tipo);
//	<T> Page<T> findAll(Specification<E> spec, Pageable pageable, Class<T> tipo);
//	<T> List<T> findAll(Specification<E> spec, Sort sort, Class<T> tipo);
}

