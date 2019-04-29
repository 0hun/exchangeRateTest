package com.example.exchange.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {
	
	String success;
	String terms;
	String privacy;
	String timestamp;
	String source;
	Object quotes;
}
