package com.example.exchange.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.exchange.domain.Quote;


@Service
public class ExchangeService {
	
	Logger logger = org.slf4j.LoggerFactory.getLogger(ExchangeService.class);

	public String getExchangeRate(String source, String currencies) {
        final String url = "http://www.apilayer.net/api/live";
        final String serviceKey = "2961bbc0cb20115c93a5ba8427f4ee8a";
        
        RestTemplate restTemplate = new RestTemplate();
        
        UriComponents builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("access_key", serviceKey)
                .queryParam("currencies", currencies)
                .queryParam("source", source)
                .queryParam("format", 1)
                .build(false);    //자동으로 encode해주는 것을 막기 위해 false
        
        Quote quote = restTemplate.getForObject(builder.toUriString(), Quote.class);
        String[] str;
        String rate = "";
        
        if (quote != null) {
        	logger.info(quote.toString());
        	
        	str = quote.getQuotes().toString().split("=");
        	rate = str[1].substring(0, str[1].length() - 1);
        	
        	logger.info("rate=" + rate);
        } 
        
        return rate;
	}
	
}
