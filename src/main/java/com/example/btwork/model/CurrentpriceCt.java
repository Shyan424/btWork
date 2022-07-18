package com.example.btwork.model;

import java.sql.Timestamp;

public class CurrentpriceCt {
	
	private String codeEn;
	
	private String codeCt;

	private String rate;
	
	private Timestamp updateTime;

	public String getCodeEn() {
		return codeEn;
	}

	public void setCodeEn(String codeEn) {
		this.codeEn = codeEn;
	}

	public String getCodeCt() {
		return codeCt;
	}

	public void setCodeCt(String codeCt) {
		this.codeCt = codeCt;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	
}
