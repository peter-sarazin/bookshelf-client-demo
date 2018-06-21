package com.petersarazin.bookshelf.dto;

public class PublisherDto
{
	private Integer publisherId;
	private String name;
	private String url;
	
	public Integer getPublisherId() { return publisherId; }
	public void setPublisherId( Integer publisherId ) { this.publisherId = publisherId; }
	
	public String getName() { return name; }
	public void setName( String name ) { this.name = name; }
	
	public String getUrl() { return url; }
	public void setUrl( String url ) { this.url = url; }
}
