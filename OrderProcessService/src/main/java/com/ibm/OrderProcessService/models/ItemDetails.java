package com.ibm.OrderProcessService.models;
 
  import javax.persistence.Column; 
  import javax.persistence.Embeddable; 
  import javax.persistence.Entity; 
  import javax.persistence.Table;

@Embeddable
@Table(name="item")
public class ItemDetails {

	@Column(name = "name")
	private String name;
	
	@Column(name ="price")
	private int price;
	
	@Column(name ="quanity")
	private String quantity;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	
}