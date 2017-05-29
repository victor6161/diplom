package com.diplom.kozlov.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
 
@Entity
@Table(name = "vessel")
public class VesselEntity {
  public VesselEntity() {
		super();
		
	}
@Override
	public String toString() {
		return "VesselEntity [id=" + id + ", type=" + type + ", name=" + name + ", fuelConsumption=" + fuelConsumption
				+ ", loadCapacity=" + loadCapacity + ", averageSpeed=" + averageSpeed + "]";
	}
  @Id
  @GeneratedValue
  @Setter
  @Getter
  private Integer id;
  @Setter
  @Getter
  private String type;
  @Setter
  @Getter
  private String name;
  @Setter
  @Getter
  @Column(name = "fuel_consumption")
  private Double fuelConsumption;
  @Setter
  @Getter
  @Column(name = "load_capacity")
  private Double loadCapacity;
  @Setter
  @Getter
  @Column(name = "average_speed")
  private Double averageSpeed;
  @Setter
  @Getter
  private Double draught;
  @Setter
  @Getter
  private Double length;
  @Setter
  @Getter
  private Double width;


}
