package com.petersarazin.books.client.thymeleaf.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties( "bookService" )
public class BookServiceProperties {

	private String baseUrl;

	public String getBaseUrl() { return baseUrl; }
	public void setBaseUrl(String baseUrl) { this.baseUrl = baseUrl; }
}
