package com.diplom.kozlov.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "service")
public class ServiceEntity {
	  @Override
	public String toString() {
		return "ServiceEntity [id=" + id + ", title=" + title + ", vessel=" + vessel + ", routeEntity=" + routeEntity
				+ "]";
	}
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Setter
	  @Getter
	  private Integer id;
	  @Setter
	  @Getter
	  private String title;
	  
	
	  @Setter
	  @Getter
	  @ManyToOne
	  @JoinColumn(name="vessel_id")
	  private VesselEntity vessel;
	  
	  @Setter
	  @Getter
	  @ManyToMany
	  @JoinTable(name="route_service",joinColumns={@JoinColumn(name="service_id")},inverseJoinColumns={@JoinColumn(name="route_id")})
	  private Set<RouteEntity> routeEntity = new HashSet<>();
	  public void addToRoute(RouteEntity routeEntity) {
		  this.routeEntity.add(routeEntity);
	  }

}
