package com.mascotas.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Mascota {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String name;
	private String race;
	private String telephone;
	private Date birthDate;
	@Enumerated(EnumType.STRING)
	private Type type;
	
	public Mascota() {}
	
	@PrePersist
	void birthDate() {
		this.birthDate = new Date();
	}

	public Mascota(String name, String race, String telephone, Date birthDate, Type type) {
		super();
		this.name = name;
		this.race = race;
		this.telephone = telephone;
		this.birthDate = birthDate;
		this.type = type;
	}

	public static enum Type{
		DOG, CAT, FISH
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
	
	
	
}
