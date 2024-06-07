package com.example.domains.contracts.repositories;

import java.util.List;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.domains.entities.User;

// CREATE INDEX IF NOT EXISTS firstname_idx ON videodb.users (firstname);

public interface UsersRepository extends CassandraRepository<User, String> {
	List<User> findByFirstname(String nombre);
	List<User> findByLastname(String apellidos);
}
