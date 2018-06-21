package com.petersarazin.bookshelf.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.petersarazin.bookshelf.model.BookForAddModel;

public class BookForAddModelValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> arg0)
	{
		return BookForAddModel.class.equals( arg0 );
	}

	@Override
	public void validate( Object object, Errors e )
	{
		BookForAddModel bookForAddModel = ( BookForAddModel )object;
		
		if( StringUtils.isEmpty( bookForAddModel.getTitle() ) )
		{
			e.rejectValue( "title", "NoDataEntered" );
		}
		
		if(StringUtils.isEmpty( bookForAddModel.getIsbn() ) )
		{
			e.rejectValue( "isbn", "NoDataEntered" );
		}
	}
	

}
