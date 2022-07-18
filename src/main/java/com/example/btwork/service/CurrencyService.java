package com.example.btwork.service;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.btwork.Repository.CurrencyRepostitory;
import com.example.btwork.entity.Currency;
import com.example.btwork.model.ResponseVo;
import com.example.btwork.service.interfaces.ICurrencyService;

@Service
public class CurrencyService implements ICurrencyService {

	@Autowired
	private CurrencyRepostitory currencyRepostitory;

	@Override
	public Currency getCurrencyByEn(Long id) {
		return currencyRepostitory.findById(id).orElse(null);
	}

	@Override
	public Currency saveCurrency(Currency saveItem) {
		return currencyRepostitory.save(saveItem);
	}

	@Override
	public Currency modifyCurrency(Currency modify) {
		return currencyRepostitory.save(modify);
	}

	@Override
	public ResponseVo deleteCurrency(Long id) {
		ResponseVo res = new ResponseVo();
		if(currencyRepostitory.findById(id).isPresent()) {
			currencyRepostitory.deleteById(id);
			res.setMessage("OK");
		} else {
			res.setMessage("FAIL");
		}
		
		return res;
	}

	@Override
	public List<Currency> getCurrenctByEn(Set<String> en) {
		return currencyRepostitory.findByCurrencyEnIn(en);
	}
	
}
