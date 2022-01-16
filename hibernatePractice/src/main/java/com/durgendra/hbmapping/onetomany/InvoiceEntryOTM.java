package com.durgendra.hbmapping.onetomany;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "inventry_one_to_many")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvoiceEntryOTM {
	
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "inve_id")
	@OrderColumn(name = "inve_seq")
	private List<CorporateDetailOTM> corpDetail;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "inve_id")
	@OrderColumn(name = "inve_seq")
	private List<InvoiceEntryDetailOTM> ied;
	

}
