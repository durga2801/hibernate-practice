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
@Table(name ="inv_entry_detail_one_to_one")
@NoArgsConstructor
@Data
public class InvoiceEntryDetailOTO {
	
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

	@OneToOne(targetEntity = InvoiceEntryOTO.class)
	private InvoiceEntryOTO invEntry;

	public InvoiceEntryDetailOTO(Long id, String number, Double amount, String txId, Long inv_id) {
		super();
		this.id = id;
		this.number = number;
		this.amount = amount;
		this.txId = txId;
		this.inv_id = inv_id;
	}
	
	
}
