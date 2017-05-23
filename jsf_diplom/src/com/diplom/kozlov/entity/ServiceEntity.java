package com.diplom.kozlov.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "service")
public class ServiceEntity {
	  @Id
	  @Setter
	  @Getter
	  private Integer id;
	  @Setter
	  @Getter
	  private String title;
	  @Setter
	  @Getter
	  private int total_time;
	
	  @Setter
	  @Getter
	  @ManyToOne
	  @JoinColumn(name="vessel_id")
	  private VesselEntity vessel;

}
