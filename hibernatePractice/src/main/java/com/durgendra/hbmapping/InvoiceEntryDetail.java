package com.durgendra.hbmapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name ="inv_entry_detail")
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceEntryDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name ="inv_det_id")
	private Long id;
	
	@Column(name ="inv_number")
	private String number;
	
	@Column(name="inv_amount")
	private Double amount;
	
	@Column(name = "inv_txn_id")
	private String txId;
	
	@Column(name ="inv_id")
	private Long inv_id;

}
