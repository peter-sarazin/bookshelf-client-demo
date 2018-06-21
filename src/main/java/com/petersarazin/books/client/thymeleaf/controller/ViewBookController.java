package com.petersarazin.books.client.thymeleaf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.petersarazin.books.dto.BookDto;

@Controller
public class ViewBookController {
	
	@Value( "${bookService.baseUrl}")
	private String bookServiceBaseUrl;
	
	@GetMapping( "/viewBook/{bookId}")
	public ModelAndView viewBook( @PathVariable( "bookId" ) Integer bookId ) {
		
		ModelAndView modelAndView = new ModelAndView( "viewBook" );
		
		RestTemplate restTemplate = new RestTemplate();
		String url = bookServiceBaseUrl + "/book/" + bookId;
		BookDto bookDto = restTemplate.getForObject( url, BookDto.class );
		modelAndView.addObject( "book", bookDto );
		return modelAndView;
	}
}
