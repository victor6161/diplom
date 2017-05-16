package com.diplom.kozlov.entity;

import java.io.Serializable;


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
@Table(name = "port")
public class PortEntity implements Serializable {

	@Override
	public String toString() {
		return "PortEntity [id=" + id + ", country=" + country + ", name=" + name + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
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
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "country_id", nullable = false)
	private CountryEntity country;

	@Setter
	@Getter
	private String name;
	@Setter
	@Getter
	private Double latitude;
	@Setter
	@Getter
	private Double longitude;
}
