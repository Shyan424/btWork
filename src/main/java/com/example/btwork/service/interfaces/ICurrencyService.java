package com.example.btwork.service.interfaces;

import java.util.List;
import java.util.Set;

import com.example.btwork.entity.Currency;
import com.example.btwork.model.ResponseVo;

public interface ICurrencyService {

	public Currency getCurrencyByEn(Long id);
	
	public Currency saveCurrency(Currency saveItem);
	
	public Currency modifyCurrency(Currency modify);
	
	public ResponseVo deleteCurrency(Long id);
	
	public List<Currency> getCurrenctByEn(Set<String> en);
	
}
