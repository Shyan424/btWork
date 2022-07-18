package com.example.btwork.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

import com.example.btwork.BtworkApplicationTests;
import com.example.btwork.entity.Currency;
import com.fasterxml.jackson.databind.ObjectMapper;

@Order(1)
class CurrencyControllerTest extends BtworkApplicationTests{

	@Autowired
	private MockMvc mvc;
	
	@Autowired
	private ObjectMapper mapper;
	
	static Currency newCurrency;
	
	@BeforeAll
	static void init() {
		newCurrency = new Currency();
		newCurrency.setCurrencyEn("NTD");
		newCurrency.setCurrencyCht("新台幣");
	}
	
	@Test
	@Order(1)
	void findById() throws Exception {
		mvc.perform(get("/currency/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.currencyEn", is("USD")))
			.andExpect(jsonPath("$.currencyCht", is("美元")))
			.andDo(print());
	}
	
	@Test
	@Order(2)
	void save() throws Exception {
		mvc.perform(post("/currency")
				.param("currencyEn", newCurrency.getCurrencyEn())
				.param("currencyCht", newCurrency.getCurrencyCht()))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.currencyId").exists())
			.andExpect(jsonPath("$.currencyEn", is(newCurrency.getCurrencyEn())))
			.andExpect(jsonPath("$.currencyCht", is(newCurrency.getCurrencyCht())))
			.andDo(r -> {
				newCurrency = mapper.readValue(r.getResponse().getContentAsString(), Currency.class);
			});
	}

	@Test
	@Order(3)
	void modify() throws Exception {
		mvc.perform(put("/currency")
				.param("currencyId", newCurrency.getCurrencyId().toString())
				.param("currencyEn", "JPY")
				.param("currencyCht", "日圓"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.currencyId", is(newCurrency.getCurrencyId().intValue())))
			.andExpect(jsonPath("$.currencyEn", is("JPY")))
			.andExpect(jsonPath("$.currencyCht", is("日圓")))
			.andDo(print())
			.andDo(r -> {
				newCurrency = mapper.readValue(r.getResponse().getContentAsString(), Currency.class);
			});
	}
	
	@Test
	@Order(4)
	void deleteById() throws Exception {
		mvc.perform(delete("/currency/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.message", is("OK")));
	}
	
}
