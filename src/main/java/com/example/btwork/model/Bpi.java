package com.example.btwork.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({
	"code",
	"description",
	"rate",
	"rate_float",	
	"symbol",	
})
public class Bpi {
	private String code;
	
	private String description;
	
	private String rate;
	
	@JsonProperty("rate_float")
	private Double rateFloat;
	
	private String symbol;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Double getRateFloat() {
		return rateFloat;
	}

	public void setRateFloat(Double rateFloat) {
		this.rateFloat = rateFloat;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public String toString() {
		return "Currency [code=" + code + ", description=" + description + ", rate=" + rate + ", rateFloat=" + rateFloat
				+ ", symbol=" + symbol + "]";
	}
	
}
