package com.diplom.kozlov.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "country")
public class CountryEntity {
	  @Override
	public String toString() {
		return "CountryEntity [id=" + id + ", name=" + name + ", postcode=" + postcode + ", tax=" + tax + "]";
	}
	public CountryEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	  @GeneratedValue
	  @Setter
	  @Getter
	  private Integer id;
	  
	  @Setter
	  @Getter
	  private String name;
	  @Setter
	  @Getter
	  private String postcode;
	  @Setter
	  @Getter
	  private Integer tax;
}
