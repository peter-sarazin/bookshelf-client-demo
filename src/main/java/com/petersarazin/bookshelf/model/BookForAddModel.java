package com.petersarazin.bookshelf.model;

import java.math.BigDecimal;

public class BookForAddModel
{
	private Integer bookId;
	private String title;
	private String isbn;
	private BigDecimal price;
	private String imageUrl;
	private String publisherId;
	private String authorIds;
	
	public Integer getBookId() { return bookId; }
	public void setBookId( Integer bookId ) { this.bookId = bookId; }
	
	public String getTitle() { return title; }
	public void setTitle( String title ) { this.title = title; }
	
	public String getIsbn() { return isbn; }
	public void setIsbn( String isbn ) { this.isbn = isbn; }
	
	public String getPublisherId() { return publisherId; }
	public void setPublisherId( String publisherId ) { this.publisherId = publisherId; }
	
	public BigDecimal getPrice() { return price; }
	public void setPrice( BigDecimal price ) { this.price = price; }

	public String getImageUrl() { return imageUrl; }
	public void setImageUrl( String imageUrl ) { this.imageUrl = imageUrl; }
	
	public String getAuthorIds() { return authorIds; }
	public void setAuthorIds( String authorIds ) { this.authorIds = authorIds; }
}
