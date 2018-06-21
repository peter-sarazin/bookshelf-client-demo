package com.petersarazin.bookshelf.dto;

public class AuthorDto
{
	private Integer authorId;
	private String firstName;
	private String middleName;
	private String lastName;
	
	public Integer getAuthorId() { return authorId; }
	public void setAuthorId( Integer authorId ) { this.authorId = authorId; }
	
	public String getFirstName() { return firstName; }
	public void setFirstName( String firstName ) { this.firstName = firstName; }
	
	public String getMiddleName() { return middleName; }
	public void setMiddleName( String middleName ) { this.middleName = middleName; }
	
	public String getLastName() { return lastName; }
	public void setLastName( String lastName ) { this.lastName = lastName; }
}
