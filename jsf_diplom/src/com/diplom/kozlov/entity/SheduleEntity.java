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
public class SheduleEntity implements Serializable {
	

	@Override
	public String toString() {
		return "SheduleEntity [id=" + id + ", portFrom=" + portFrom + ", portTo=" + portTo + ", dateFrom=" + dateFrom
				+ ", dateTo=" + dateTo + ", vessel=" + vessel + ", numPoints=" + numPoints + ", markersEntity="
				+ markersEntity + "]";
	}




	  @Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY)
	  @Setter
	  @Getter
	  private Integer id;
	  @Setter
	  @Getter
	  @ManyToOne// Not-null property references a transient value - transient instance must be saved before current operation : com.diplom.kozlov.entity.SheduleEntity.portFrom -> com.diplom.kozlov.entity.PortEntity
	  @JoinColumn(name="port_id_from", nullable=false, updatable=false)
	  private PortEntity portFrom;
	  
	  @Setter
	  @Getter
	  @ManyToOne
	  @JoinColumn(name="port_id_to", nullable=false, updatable=true)
	  private PortEntity portTo;
	  @Setter
	  @Getter
	  @Column(name = "date_from")
	  private Date dateFrom;
	  @Setter
	  @Getter
	  @Column(name = "date_to")
	  private Date dateTo;
	  @Setter
	  @Getter
	  @ManyToOne
	  @JoinColumn(name="vessel_id", nullable=false, updatable=false)
	  private VesselEntity vessel;
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
