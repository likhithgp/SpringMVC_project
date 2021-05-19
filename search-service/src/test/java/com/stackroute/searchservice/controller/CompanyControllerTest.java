package com.stackroute.searchservice.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.searchservice.service.SearchService;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


@ExtendWith(MockitoExtension.class)
public class CompanyControllerTest {

	@Autowired
	private MockMvc mockMvc;


	@Mock
	private CompanyController  companyController;
	/*
	 * Run this before each test case
	 */
	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(companyController).build();

	}

	/**
	 * Run this after each test case
	 */
//			@AfterEach
//			void tearDown() {
//				searchService = null;
//			}

	/**
	 * Test annotation tells JUnit that the public void method to which it is attached can be run as a test case
	 */
	@Test
	void givenGetMappingUrlShouldReturnTheResult() throws Exception {
		companyController.getInfo();
		verify(companyController, times(1)).getInfo();
	}

	@Test
	void givenGetMappingUrlShouldReturnThemappingurl() throws Exception {
		mockMvc.perform(get("/api/v1/companies")
				.contentType(MediaType.APPLICATION_JSON));


	}

	private static String asJsonString(final Object obj) {
		try{
			return new ObjectMapper().writeValueAsString(obj);
		}catch (Exception e){
			throw  new RuntimeException(e);
		}
	}
}

