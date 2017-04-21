package com.diplom.kozlov.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;



import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "route")
public class SheduleEntity {
	
	  @Override
	public String toString() {
		return "SheduleEntity [id=" + id + ", portFrom=" + portFrom + ", portTo=" + portTo + ", dateFrom=" + dateFrom
				+ ", dateTo=" + dateTo + ", vessel=" + vessel + "]";
	}
	@Id
	  @GeneratedValue
	  @Setter
	  @Getter
	  private Integer id;
	  @Setter
	  @Getter
	  @ManyToOne
	  @JoinColumn(name="port_id_from", nullable=false, updatable=false)
	  private PortEntity portFrom;
	  
	  @Setter
	  @Getter
	  @ManyToOne
	  @JoinColumn(name="port_id_to", nullable=false, updatable=false)
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
}
