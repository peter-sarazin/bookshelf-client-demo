package com.petersarazin.bookshelf.dto.response;

import java.util.List;

import com.petersarazin.bookshelf.dto.BookDto;

public class GetBooksResponse
{
	private List<BookDto> bookList;

	public List<BookDto> getBookList() { return bookList; }
	public void setBookList( List<BookDto> bookList ) { this.bookList = bookList; }	
}
