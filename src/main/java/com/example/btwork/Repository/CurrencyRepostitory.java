package com.example.btwork.Repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.btwork.entity.Currency;

@Repository
public interface CurrencyRepostitory extends JpaRepository<Currency, Long> {

	public List<Currency> findByCurrencyEnIn(Set<String> currencyEn);
	
}
