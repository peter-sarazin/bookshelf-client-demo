package com.petersarazin.bookshelf.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.petersarazin.bookshelf.dto.AuthorDto;
import com.petersarazin.bookshelf.dto.BookForAddDto;
import com.petersarazin.bookshelf.dto.PublisherDto;
import com.petersarazin.bookshelf.dto.response.AddBookResponse;
import com.petersarazin.bookshelf.dto.response.GetAuthorsResponse;
import com.petersarazin.bookshelf.dto.response.GetPublishersResponse;
import com.petersarazin.bookshelf.model.BookForAddModel;
import com.petersarazin.bookshelf.validator.BookForAddModelValidator;

@Controller
public class AddBookController {

	@Value( "${bookService.baseUrl}")
	private String bookServiceBaseUrl;

	@ModelAttribute( "publisherList" )
	public List<PublisherDto> populatePublishers() {
		
		RestTemplate restTemplate = new RestTemplate();
		GetPublishersResponse getPublishersResponse = restTemplate.getForObject( bookServiceBaseUrl + "/publisher", GetPublishersResponse.class );
		List<PublisherDto> publisherList = getPublishersResponse.getPublisherList();
		return publisherList;
	}
	
	@ModelAttribute( "authorList" )
	public List<AuthorDto> populateAuthors() {
		
		RestTemplate restTemplate = new RestTemplate();
		GetAuthorsResponse getAuthorsResponse = restTemplate.getForObject( bookServiceBaseUrl + "/author", GetAuthorsResponse.class );
		List<AuthorDto> authorList = getAuthorsResponse.getAuthorList();
		return authorList;
	}
	
	
	@GetMapping( "/addBook" )
	public ModelAndView addNewBook( Model model ) {
		
		ModelAndView modelAndView = new ModelAndView( "addBook" );
		
		Map<String, Object> modelMap = model.asMap();
    	Object bookForAddModelAsObject = modelMap.get( "bookForAddModel" );
    	BookForAddModel bookForAddModel = ( BookForAddModel )bookForAddModelAsObject;

		if( bookForAddModel == null  ) {
			
			modelAndView.addObject( "bookForAddModel", new BookForAddModel() );
		}

		return modelAndView;
	}
	
	@PostMapping( "/addBook" )
	public String saveNewBook( @Valid BookForAddModel bookForAddModel, BindingResult bindingResult, RedirectAttributes redirectAttributes, Model model  ) {

		String view = null;

		new BookForAddModelValidator().validate( bookForAddModel, bindingResult );

		if( bindingResult.hasErrors() ) {

			Map<String, Object> modelMap = model.asMap();
			Set<String> keySet = modelMap.keySet();
			
			for( String key : keySet ) {
				
				redirectAttributes.addFlashAttribute( key,  modelMap.get( key ) );
			}
			
			view = "redirect:/addBook";
		}
		else {

			RestTemplate restTemplate = new RestTemplate();
			restTemplate.getMessageConverters().add( new MappingJackson2HttpMessageConverter() );
			restTemplate.getMessageConverters().add( new StringHttpMessageConverter() );
			
			BookForAddDto bookForAddDto = new BookForAddDto();
			bookForAddDto.setTitle( bookForAddModel.getTitle() );
			bookForAddDto.setIsbn( bookForAddModel.getIsbn() );
			bookForAddDto.setPrice( bookForAddModel.getPrice() );
			bookForAddDto.setImageUrl( bookForAddModel.getImageUrl() );
			
			// publisher
			Integer publisherId = Integer.valueOf( bookForAddModel.getPublisherId() );
			bookForAddDto.setPublisherId( publisherId );
			
			// authors
			String authorIdsAsString = bookForAddModel.getAuthorIds();

			List<Integer> authorIdlist = Stream.of( authorIdsAsString.split( "," ) )
			        .map( Integer::valueOf )
			        .collect(Collectors.toList());
			
			bookForAddDto.setAuthorIds( authorIdlist );
			
			restTemplate.postForObject( bookServiceBaseUrl + "/book", bookForAddDto, AddBookResponse.class );
			
			view = "home";
		}
		
		return view;
	}
}
