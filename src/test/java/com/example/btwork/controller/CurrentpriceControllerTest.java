package com.example.btwork.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.example.btwork.BtworkApplicationTests;

class CurrentpriceControllerTest extends BtworkApplicationTests{

	@Autowired
	private MockMvc mvc;
	
	@Test
	void currentPrice() throws Exception {
		mvc.perform(get("/currentprice"))
			.andExpect(status().isOk())
			.andDo(print());
	}
	
	@Test
	void currentPriceCht() throws Exception {
		mvc.perform(get("/currentprice/cht"))
			.andExpect(status().isOk())
			.andDo(print());
	}

}
