package com.petersarazin.bookshelf.dto;

import java.math.BigDecimal;
import java.util.List;

public class BookDto
{
	private Integer bookId;
	private String title;
	private String isbn;
	private List<AuthorDto> authors;
	private PublisherDto publisher;
	private BigDecimal price;
	private String imageUrl;
	
	public Integer getBookId() { return bookId; }
	public void setBookId( Integer bookId ) { this.bookId = bookId; }
	
	public String getTitle() { return title; }
	public void setTitle( String title ) { this.title = title; }
	
	public String getIsbn() { return isbn; }
	public void setIsbn( String isbn ) { this.isbn = isbn; }
	
	public List<AuthorDto> getAuthors() { return authors; }
	public void setAuthors( List<AuthorDto> authors ) { this.authors = authors; }
	
	public PublisherDto getPublisher() { return publisher; }
	public void setPublisher( PublisherDto publisher ) { this.publisher = publisher; }
	
	public BigDecimal getPrice() { return price; }
	public void setPrice( BigDecimal price ) { this.price = price; }

	public String getImageUrl() { return imageUrl; }
	public void setImageUrl( String imageUrl ) { this.imageUrl = imageUrl; }
}
