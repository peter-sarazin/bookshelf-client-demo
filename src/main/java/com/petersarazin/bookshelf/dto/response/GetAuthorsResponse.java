package com.petersarazin.bookshelf.dto.response;

import java.util.List;

import com.petersarazin.bookshelf.dto.AuthorDto;

public class GetAuthorsResponse
{
	private List<AuthorDto> authorList;

	public List<AuthorDto> getAuthorList() { return authorList; }
	public void setAuthorList( List<AuthorDto> authorList ) { this.authorList = authorList; }
}
