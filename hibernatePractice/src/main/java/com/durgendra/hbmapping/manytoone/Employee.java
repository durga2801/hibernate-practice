package com.durgendra.hbmapping.manytoone;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name ="employee")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String code;
	private String email;

	@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
	@OneToOne(cascade = CascadeType.ALL)
	private Address address;

}
