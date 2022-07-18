package com.example.btwork.service.interfaces;

import java.util.List;
import java.util.Map;

import com.example.btwork.model.Currentprice;
import com.example.btwork.model.CurrentpriceCt;

public interface ICurrentpriceService {
	
	public Currentprice getCurrentprice();
	
	public Map<String, List<CurrentpriceCt>> getCurrenctpriceCt();

}
