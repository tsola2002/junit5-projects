package com.tsola2002.datjpa;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@SpringBootTest
@AutoConfigureMockMvc
class DatjpaApplicationTests {

	//using dependency injection to inject mock object
	@Autowired
	private MockMvc mockMvc;

	private static MockHttpServletRequest request;
	public static final MediaType APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON;

	@BeforeAll
	public static void setup() {
		request = new MockHttpServletRequest();
	}

	@Test
	public void getAllStudents() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/students"))
				.andExpect(status().isOk())
				.andExpect((ResultMatcher) content().contentType(APPLICATION_JSON_UTF8))
				.andExpect((ResultMatcher) jsonPath("$", hasSize(3)));
	}

	@Test
	void contextLoads() {
	}

}
