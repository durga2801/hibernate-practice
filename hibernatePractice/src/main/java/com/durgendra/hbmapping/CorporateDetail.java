package com.durgendra.hbmapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "corp_detail")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CorporateDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "corp_id")
	private Long id;
	
	@Column(name ="corp_type")
	private String type;
	
	@Column(name="corp_code")
	private String code;
	
	@Column(name = "corp_name")
	private String name;
	
	
}
