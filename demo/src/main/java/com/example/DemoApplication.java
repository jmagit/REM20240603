package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.example.domains.entities.Actor;
import com.example.domains.entities.Film;
import com.example.domains.entities.models.ActorDTO;
import com.example.domains.entities.models.ActorShort;
import com.example.domains.repositories.ActorRepository;
import com.example.domains.repositories.FilmRepository;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Autowired
	ActorRepository dao;
	
	@Autowired
	FilmRepository daoPeli;
	
	@Value("${mi.valor:Valor por defecto}")
	String config;
	
	@Override
	@Transactional
	public void run(String... args) throws Exception {
		System.err.println("Aplicación arrancada!!!!.");
		System.err.println(config);
		
//		dao.save(new Actor(0, "Pepito", "Grillo"));
//		var item = dao.findById(204);
//		if(item.isPresent()) {
//			var actor = item.get();
//			actor.setFirstName(actor.getFirstName().toUpperCase());
//			dao.save(actor);
//		}
//		dao.deleteById(205);
//		dao.findAll().forEach(System.out::println);
//		dao.findTop5ByFirstNameStartingWithOrderByLastNameDesc("P").forEach(System.out::println);
//		dao.findTop5ByFirstNameStartingWith("P", Sort.by("firstName").descending()).forEach(System.out::println);
//		dao.findByActorIdGreaterThan(200).forEach(System.out::println);
//		dao.findByJPA(200).forEach(System.out::println);
//		dao.findBySQL(200).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.greaterThan(root.get("actorId"), 200)).forEach(System.out::println);
//		dao.findAll((root, query, builder) -> builder.lessThanOrEqualTo(root.get("actorId"), 10)).forEach(System.out::println);
//		var item = dao.findById(1);
//		if(item.isPresent()) {
//			var actor = item.get();
//			System.out.println(actor);
//			actor.getFilmActors().forEach(p -> System.out.println(p.getFilm().getTitle()));
//		}
//		dao.findAll(PageRequest.of(1, 10, Sort.by("firstName"))).getContent().forEach(System.out::println);
//		dao.save(new Actor(0, "Pepito", "Grillo"));
//		var actor = new Actor(0, "", "12345678z");
//		if(actor.isValid()) {
//			dao.save(actor);
//		} else {
//			System.err.println(actor.getErrorsFields());
//		}
//		dao.findByActorIdGreaterThan(200).forEach(item -> System.out.println(ActorDTO.from(item)));
//		dao.queryByActorIdGreaterThan(200).forEach(System.out::println);
//		dao.readByActorIdGreaterThan(200).forEach(item -> System.out.println(item.getId() + " -> " + item.getNombre()));
//		dao.readByActorIdGreaterThan(200).forEach(item -> System.out.println(item.getClass().getName()));
//		dao.searchByActorIdGreaterThan(200, Actor.class).forEach(System.out::println);
//		dao.searchByActorIdGreaterThan(200, ActorDTO.class).forEach(System.out::println);
//		dao.searchByActorIdGreaterThan(200, ActorShort.class).forEach(item -> System.out.println(item.getId() + " -> " + item.getNombre()));
//		record Local(int actorId, String firstName) {}
//		dao.searchByActorIdGreaterThan(200, Local.class).forEach(System.out::println);
		var objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
//		var objectMapper = new com.fasterxml.jackson.dataformat.xml.XmlMapper();

//		System.out.println(objectMapper.writeValueAsString(dao.findById(1).get()));
//		System.out.println(objectMapper.writeValueAsString(dao.searchByActorIdGreaterThan(200, ActorDTO.class)));
//		System.out.println(objectMapper.writeValueAsString(dao.findAllBy(ActorShort.class)));
		record PeliLocal(@JsonProperty("id") int filmId, @JsonProperty("titulo") String title) {}
		System.out.println(objectMapper.writeValueAsString(daoPeli.findAllBy(PeliLocal.class)));

	}

}
