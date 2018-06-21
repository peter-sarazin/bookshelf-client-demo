package com.petersarazin.books.client.thymeleaf.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.petersarazin.books.dto.BookDto;
import com.petersarazin.books.dto.response.GetBooksResponse;

@Controller
public class HomeController {

	@Value( "${bookService.baseUrl}")
	private String bookServiceBaseUrl;

	@GetMapping( "/" )
	public ModelAndView getHomePage() {
		
		ModelAndView modelAndView = new ModelAndView( "home" );

		RestTemplate restTemplate = new RestTemplate();
		GetBooksResponse getBooksResponse = restTemplate.getForObject( bookServiceBaseUrl + "/book", GetBooksResponse.class );
		List<BookDto> bookList = getBooksResponse.getBookList();
		
		modelAndView.addObject( "bookList", bookList );
		
		return modelAndView;
	}
}
