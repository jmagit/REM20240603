package com.example.domains.entities.models;

import com.example.domains.entities.Actor;

import lombok.Data;

@Data
public class ActorDTO {
	private int id;
	private String firstName;
	private String lastName;

	public ActorDTO(int actorId, String firstName, String lastName) {
		this.id = actorId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public static Actor from(ActorDTO source) {
		return new Actor(
				source.getId(),
				source.getFirstName(),
				source.getLastName()
				);
	}
	public static ActorDTO from(Actor source) {
		return new ActorDTO(
				source.getActorId(),
				source.getFirstName(),
				source.getLastName()
				);
	}
}
