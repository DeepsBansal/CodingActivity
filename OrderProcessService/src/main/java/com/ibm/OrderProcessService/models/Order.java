package com.ibm.OrderProcessService.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orderdetails")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="customer" ,nullable = false)
	private String customerName;
	
	@ElementCollection
	@JoinTable(name ="item" ,joinColumns =@JoinColumn(name ="id" ))
	private Set<ItemDetails> itemDetails = new HashSet<ItemDetails>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public Set<ItemDetails> getItemDetails() {
		return itemDetails;
	}

	public void setItemDetails(Set<ItemDetails> itemDetails) {
		this.itemDetails = itemDetails;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	

}
