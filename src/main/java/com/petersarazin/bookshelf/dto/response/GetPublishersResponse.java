package com.petersarazin.bookshelf.dto.response;

import java.util.List;

import com.petersarazin.bookshelf.dto.PublisherDto;

public class GetPublishersResponse
{
	private List<PublisherDto> publisherList;

	public List<PublisherDto> getPublisherList() { return publisherList; }
	public void setPublisherList( List<PublisherDto> publisherList ) { this.publisherList = publisherList; }
}
