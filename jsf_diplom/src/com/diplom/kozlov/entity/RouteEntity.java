package com.diplom.kozlov.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "route")
public class RouteEntity implements Serializable {
	






	  @Override
	public String toString() {
		return "RouteEntity [id=" + id + ", portFrom=" + portFrom + ", portTo=" + portTo + ", distance=" + distance
				+ ", numPoints=" + numPoints + ", markersEntity=" + markersEntity + "]";
	}

	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Setter
	  @Getter
	  private Integer id;
	  @Setter
	  @Getter
	  @ManyToOne// Not-null property references a transient value - transient instance must be saved before current operation : com.diplom.kozlov.entity.SheduleEntity.portFrom -> com.diplom.kozlov.entity.PortEntity
	  @JoinColumn(name="port_id_from", nullable=false)
	  private PortEntity portFrom;
	  
	  @Setter
	  @Getter
	  @ManyToOne
	  @JoinColumn(name="port_id_to", nullable=false)
	  private PortEntity portTo;
	  @Setter
	  @Getter
	  private double distance;
	
	  @Setter
	  @Getter
	  @Column(name="number_points")
	  private int numPoints;
	  
	  @Setter
	  @Getter
	  @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	  @JoinColumn(name = "route_id")
	  private List<MarkerEntity> markersEntity;
	  
	  
}
