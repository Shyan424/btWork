package com.example.btwork.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Currency {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long currencyId;
	
	private String currencyEn;
	
	private String currencyCht;

	public Long getCurrencyId() {
		return currencyId;
	}

	public void setCurrencyId(Long currencyId) {
		this.currencyId = currencyId;
	}

	public String getCurrencyEn() {
		return currencyEn;
	}

	public void setCurrencyEn(String currencyEn) {
		this.currencyEn = currencyEn;
	}

	public String getCurrencyCht() {
		return currencyCht;
	}

	public void setCurrencyCht(String currencyCt) {
		this.currencyCht = currencyCt;
	}

	@Override
	public String toString() {
		return "Currency [currencyId=" + currencyId + ", currencyEn=" + currencyEn + ", currencyCht=" + currencyCht
				+ "]";
	}
	
}
