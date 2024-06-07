package com.example.domains.contracts.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.domains.entities.Contacto;

public interface ContactoRepository extends CrudRepository<Contacto, String> {

}
