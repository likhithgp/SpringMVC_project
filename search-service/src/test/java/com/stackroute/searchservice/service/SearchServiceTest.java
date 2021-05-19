package com.stackroute.searchservice.service;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.stackroute.searchservice.exceptionHandling.*;
import org.mockito.Mock;
import org.json.simple.parser.ParseException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
public class SearchServiceTest
{



	@Mock
	private SearchService searchService = new SearchService() {

		@Override
		public String getSymbols(String companyName) throws CompanyNotFoundException, IOException, ParseException {
			// TODO Auto-generated method stub
			return null;
		}
	};


	private String companyName;


	@Test
	public void  givenMockingIsDoneByMockito_whenGetIsCalled_shouldReturnMockedObject1() throws CompanyNotFoundException, IOException, ParseException
	{
		searchService.getSymbols(companyName);
		verify(searchService , times(1)).getSymbols(companyName);

	}

}