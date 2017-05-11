package com.diplom.kozlov.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Setter
	@Getter
	private Integer id;
	@Setter
	@Getter
	private String firstname;
	@Setter
	@Getter
	private String lastname;
/*	@Setter
	@Getter
	private String company;*/

/*	@Setter
	@Getter
	private String phone;*/
	@Setter
	@Getter
	private String email;
/*	@Setter
	@Getter
	private String country;*/

	@Setter
	@Getter
	private String login;
	@Setter
	@Getter
	private String password;
	@Setter
	@Getter
	@Column(name = "user_role_id")
	private int roleId;

}
