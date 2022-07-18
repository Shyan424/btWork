package com.example.btwork.model;

import java.util.Map;

public class Currentprice {
	private Map<String, Bpi> bpi;
	
	private String chartName;
	
	private String disclaimer;
	
	private Times time;

	public Map<String, Bpi> getBpi() {
		return bpi;
	}

	public void setBpi(Map<String, Bpi> bpi) {
		this.bpi = bpi;
	}

	public String getChartName() {
		return chartName;
	}

	public void setChartName(String chartName) {
		this.chartName = chartName;
	}

	public String getDisclaimer() {
		return disclaimer;
	}

	public void setDisclaimer(String disclaimer) {
		this.disclaimer = disclaimer;
	}

	public Times getTime() {
		return time;
	}

	public void setTime(Times time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Currentprice [bpi=" + bpi + ", chartName=" + chartName + ", disclaimer=" + disclaimer + ", time=" + time
				+ "]";
	}
	
}
