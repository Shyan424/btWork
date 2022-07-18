package com.example.btwork.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.btwork.model.Currentprice;
import com.example.btwork.model.CurrentpriceCt;
import com.example.btwork.service.interfaces.ICurrentpriceService;

@RestController
@RequestMapping("/currentprice")
public class CurrentpriceController {

	@Autowired
	private ICurrentpriceService service;
	
	@GetMapping
	public ResponseEntity<Currentprice> getCurrentprice() {
		return ResponseEntity.ok(service.getCurrentprice());
	}
	
	@GetMapping("/cht")
	public ResponseEntity<Map<String, List<CurrentpriceCt>>> getCurrentpriceCt(){
		return ResponseEntity.ok(service.getCurrenctpriceCt());
	}
	
}
