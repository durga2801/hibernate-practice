package com.durgendra.hbmapping.onetomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "corp_detail_one_to_many")
@Data
@NoArgsConstructor
public class CorporateDetailOTM {

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

	public CorporateDetailOTM(Long id, String type, String code, String name) {
		super();
		this.id = id;
		this.type = type;
		this.code = code;
		this.name = name;
	}
	
	
}
