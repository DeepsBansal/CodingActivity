package com.ibm.OrderProcessService.models;
import java.util.HashSet;
import java.util.Set;

public class OderDTO {

	private Long id;
	private String customerName;
	public Set<ItemDetails> getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(Set<ItemDetails> itemDetails) {
		this.itemDetails = itemDetails;
	}
	private Set<ItemDetails> itemDetails = new HashSet<ItemDetails>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	
	
}
