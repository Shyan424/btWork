package com.example.btwork.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.btwork.model.Currentprice;

@Component
@FeignClient(name = "currentprice", url = "https://api.coindesk.com/v1")
public interface CurrentpriceFeign {

	@GetMapping("/bpi/currentprice.json")
	public Currentprice getCurrenctprice();
	
}
