package com.example.domains.contracts.repositories;

import java.util.UUID;

import org.springframework.data.cassandra.repository.CassandraRepository;

import com.example.domains.entities.Video;

public interface VideosRepository  extends CassandraRepository<Video, UUID> {
}
