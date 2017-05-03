package com.diplom.kozlov.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "marker")
public class MarkerEntity {
	
	@Override
	public String toString() {
		return "MarkerEntity [id=" + id + ", latitude=" + latitude + ", longitude=" + longitude + ", pathNum=" + pathNum
				+ "]";
	}
	
	public MarkerEntity() {
		super();
	}
	
	public MarkerEntity(double latitude, double longitude, int pathNum) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.pathNum = pathNum;
	}
	
	@Id
	@GeneratedValue
	@Setter
	@Getter
	private Integer id;

	@Setter
	@Getter
	private double latitude;
	@Setter
	@Getter
	private double longitude;
	@Setter
	@Getter
	@Column(name = "path_num")
	private int pathNum;
	
	@Setter
	@Getter
	@ManyToOne
	@JoinColumn(name = "route_id")
	private SheduleEntity sheduleEntity;

}
