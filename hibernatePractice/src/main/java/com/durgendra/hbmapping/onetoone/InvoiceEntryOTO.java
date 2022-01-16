package com.durgendra.hbmapping.onetoone;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "INVENTRY_one_to_one")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceEntryOTO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "inv_id")
	private Long id;
	
	@Column(name = "inv_number")
	private String invNumber;
	
	@Column(name= "inv_txn_id")
	private String invTransactionId;
	
	@Column(name= "inv_date")
	private Date invDate;
	
	@Column(name = "inv_exp_date")
	private Date InvExpDate;
	
	@OneToOne(targetEntity = CorporateDetailOTO.class, cascade = CascadeType.ALL)
	private CorporateDetailOTO seller;
	
	@OneToOne(targetEntity = CorporateDetailOTO.class, cascade = CascadeType.ALL)
	private CorporateDetailOTO buyer;
	
	@OneToOne(targetEntity = InvoiceEntryDetailOTO.class, cascade = CascadeType.ALL)
	private InvoiceEntryDetailOTO ied;
	

}
