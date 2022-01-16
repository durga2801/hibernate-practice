package com.durgendra.hbmapping;

import java.util.Date;

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
@Table(name = "INVENTRY")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InvoiceEntry {
	
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
	

}
