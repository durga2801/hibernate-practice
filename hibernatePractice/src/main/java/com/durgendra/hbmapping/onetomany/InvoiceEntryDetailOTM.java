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
@Table(name ="inv_entry_detail_one_to_many")
@NoArgsConstructor
@Data
public class InvoiceEntryDetailOTM {
	
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
	
	@Column(name ="inve_id")
	private Long inv_id;


	public InvoiceEntryDetailOTM(Long id, String number, Double amount, String txId, Long inv_id) {
		super();
		this.id = id;
		this.number = number;
		this.amount = amount;
		this.txId = txId;
		this.inv_id = inv_id;
	}
	
	
}
