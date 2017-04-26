package com.diplom.kozlov.entity;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "port")
public class PortEntity {
	

	@Override
	public String toString() {
		return "PortEntity [id=" + id + ", country=" + country + ", name=" + name + "]";
	}
	public PortEntity() {
		super();
		
	}
	  @Id
	  @GeneratedValue
	  @Setter
	  @Getter
	  private Integer id;
	  @Setter
	  @Getter
	  @ManyToOne
	  @JoinColumn(name="country_id", nullable=false, updatable=false)
	  private CountryEntity country;
	  @Setter
	  @Getter
	  private String name;
}
