package com.example.btwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.btwork.entity.Currency;
import com.example.btwork.model.ResponseVo;
import com.example.btwork.service.interfaces.ICurrencyService;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
	
	@Autowired
	private ICurrencyService currencyService;

	@GetMapping("/{id}")
	public ResponseEntity<Currency> findById(@PathVariable Long id) {
		return ResponseEntity.ok(currencyService.getCurrencyByEn(id));
	}
	
	@PostMapping
	public ResponseEntity<Currency> save(Currency saveItem) {
		return ResponseEntity.ok(currencyService.saveCurrency(saveItem));
	}
	
	@PutMapping
	public ResponseEntity<Currency> modify(Currency modify) {
		return ResponseEntity.ok(currencyService.modifyCurrency(modify));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseVo> deleteById(@PathVariable Long id) {
		return ResponseEntity.ok(currencyService.deleteCurrency(id));
	}
	
}
