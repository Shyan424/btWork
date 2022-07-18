package com.example.btwork.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.btwork.api.CurrentpriceFeign;
import com.example.btwork.entity.Currency;
import com.example.btwork.model.Bpi;
import com.example.btwork.model.Currentprice;
import com.example.btwork.model.CurrentpriceCt;
import com.example.btwork.service.interfaces.ICurrentpriceService;

@Service
public class CurrentpriceService implements ICurrentpriceService{

	@Autowired
	private CurrentpriceFeign currentpriceFeign;
	
	@Autowired
	private CurrencyService currencyService;
	
	@Override
	public Currentprice getCurrentprice() {
		return currentpriceFeign.getCurrenctprice();
	}

	@Override
	public Map<String, List<CurrentpriceCt>> getCurrenctpriceCt() {
		Currentprice price = getCurrentprice();
		System.out.println(price.getTime());
		
		return getCurrentpriceCt(price);
	}
	
	private Map<String, List<CurrentpriceCt>> getCurrentpriceCt(Currentprice price) {
		Map<String, List<CurrentpriceCt>> ctPrice = new HashMap<>();
		List<CurrentpriceCt> ctList = new ArrayList<>();
		Map<String, Bpi> bpi = price.getBpi();
		List<Currency> currencyList = currencyService.getCurrenctByEn(bpi.keySet());
		
		Map<String, Currency> entityMap = new HashMap<>();
		currencyList.forEach(v -> {
			entityMap.put(v.getCurrencyEn(), v);
		});
		
		bpi.forEach((k, v) -> {
			Currency entity = entityMap.get(k);
			CurrentpriceCt ct = new CurrentpriceCt();
			ct.setCodeEn(v.getCode());
			ct.setCodeCt(entity != null ? entity.getCurrencyCht() : "NO DATA");
			ct.setRate(v.getRate());
			ct.setUpdateTime(Timestamp.valueOf(LocalDateTime.parse(price.getTime().getUpdated(),
					DateTimeFormatter.ofPattern("MMM dd, yyyy HH:mm:ss z"))));
			ctList.add(ct);
		});
		
		ctPrice.put(price.getChartName(), ctList);
		
		return ctPrice;
	}
	
}
