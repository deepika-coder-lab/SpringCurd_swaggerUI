package com.person.api.personApi.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "person")
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The database generated product ID")
	private long id;

	@Column(name = "first_name")
	  @ApiModelProperty(notes = "The person's first_name")
	private String first_name;

	@Column(name = "last_name")
	 @ApiModelProperty(notes = "The person's last_name")
	private String last_name;

	@Column(name = "age")
	 @ApiModelProperty(notes = "The person's age")
	private int age;

	@Column(name = "favourite_colour")
	 @ApiModelProperty(notes = "The person's favourite_Colour")
	private String favourite_colour;

	@Column(name = "hobby")
	 @ApiModelProperty(notes = "The person's hobby")
	ArrayList<String> hobby = new ArrayList<String>();

	public long getId() {
		return id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getFavourite_colour() {
		return favourite_colour;
	}

	public void setFavourite_colour(String favourite_colour) {
		this.favourite_colour = favourite_colour;
	}

	public List<String> getHobby() {
		return hobby;
	}

	public void setHobby(List<String> hobby) {
		this.hobby = (ArrayList<String>) hobby;
	}

	public Person() {
		super();
	}

	public Person(long id, String first_name, String last_name, int age, String favourite_colour) {
		this.id = id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.age = age;
		this.favourite_colour = favourite_colour;
		this.hobby = hobby;
	}

}
