package com.diplom.kozlov.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "port")
public class PortEntity {
	
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
	  @Column(name = "country_id")
	  private Integer countryId;
	  @Setter
	  @Getter
	  private String name;
}
