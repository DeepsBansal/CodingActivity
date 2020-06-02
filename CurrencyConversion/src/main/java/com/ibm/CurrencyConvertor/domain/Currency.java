/**
 * 
 */
package com.ibm.CurrencyConvertor.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Deepika
 * Currency Entity
 *
 */
@Entity
@Table(name="currency")
public class Currency {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(name ="fromcountry")
	private String fromcountry;
	
	@Column(name ="tocountry")
	private String tocountry;
	
	
	@Column(name ="conversionfactor")
	private Long conversionfactor;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getFromcountry() {
		return fromcountry;
	}

	public void setFromcountry(String fromcountry) {
		this.fromcountry = fromcountry;
	}

	public String getTocountry() {
		return tocountry;
	}

	public void setTocountry(String tocountry) {
		this.tocountry = tocountry;
	}

	public Long getConversionfactor() {
		return conversionfactor;
	}

	public void setConversionfactor(Long conversionfactor) {
		this.conversionfactor = conversionfactor;
	}
	
	


	
}
