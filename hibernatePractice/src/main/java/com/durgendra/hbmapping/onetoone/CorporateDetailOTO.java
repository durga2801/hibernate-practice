package com.durgendra.hbmapping.onetoone;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "corp_detail_one_to_one")
@Data
@NoArgsConstructor
public class CorporateDetailOTO {

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
	
	@OneToOne(targetEntity = InvoiceEntryOTO.class)
	private InvoiceEntryOTO invEntry;

	public CorporateDetailOTO(Long id, String type, String code, String name) {
		super();
		this.id = id;
		this.type = type;
		this.code = code;
		this.name = name;
	}
	
	
}
