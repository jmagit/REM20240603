package com.example.domains.entities.models;

import org.springframework.data.rest.core.config.Projection;

import com.example.domains.entities.Film;
import com.fasterxml.jackson.annotation.JsonProperty;

@Projection(name = "solo-titulo", types = {Film.class})
public interface SoloTitulo {
	@JsonProperty("id")
	int getFilmId();
	String getTitle();
}
