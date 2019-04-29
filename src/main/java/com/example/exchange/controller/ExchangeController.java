package com.example.exchange.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.exchange.service.ExchangeService;

@Controller
public class ExchangeController {
	@Autowired
	ExchangeService exchangeService;
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(ExchangeController.class);

	
	@GetMapping("/")
	public String goMain() {
		return "main";
	}
	
	@GetMapping(value="/getRate")
	@ResponseBody
	public Object getData(HttpServletRequest request, Model model) {
	    String source = request.getParameter("source");
	    String currencies = request.getParameter("currencies");
	    
	    logger.info("source=" + source + ", currencies=" + currencies);
	    
	    String response = exchangeService.getExchangeRate(source, currencies);
	    
	    logger.info("response=" + response);
	    
	    return response;
	}
}
