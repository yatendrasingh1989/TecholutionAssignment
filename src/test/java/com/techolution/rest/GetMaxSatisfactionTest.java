package com.techolution.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.techolution.appstarter.AbstractAppTest;


public class GetMaxSatisfactionTest extends AbstractAppTest{
	
	@Autowired
	private WebApplicationContext context;
	
	private MockMvc mockMvc;
	
	
	@Before
	public void setUp(){
		mockMvc=MockMvcBuilders.webAppContextSetup(context).build();
	}
	
	@Test
	public void testGetMaxSatisfaction() throws Exception{
		String url ="/satisfaction/getMaxSatisfaction";
		mockMvc.perform(get(url)).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
}
