package com.petersarazin.bookshelf.dto;

import java.math.BigDecimal;
import java.util.List;

public class BookForAddDto
{
	private Integer bookId;
	private String title;
	private String isbn;
	private List<Integer> authorIds;
	private Integer publisherId;
	private BigDecimal price;
	private String imageUrl;
	
	public Integer getBookId() { return bookId; }
	public void setBookId( Integer bookId ) { this.bookId = bookId; }
	
	public String getTitle() { return title; }
	public void setTitle( String title ) { this.title = title; }
	
	public String getIsbn() { return isbn; }
	public void setIsbn( String isbn ) { this.isbn = isbn; }
	
	public List<Integer> getAuthorIds() { return authorIds; }
	public void setAuthorIds( List<Integer> authorIds ) { this.authorIds = authorIds; }
	
	public Integer getPublisherId() { return publisherId; }
	public void setPublisherId( Integer publisherId ) { this.publisherId = publisherId; }
	
	public BigDecimal getPrice() { return price; }
	public void setPrice( BigDecimal price ) { this.price = price; }

	public String getImageUrl() { return imageUrl; }
	public void setImageUrl( String imageUrl ) { this.imageUrl = imageUrl; }
}
