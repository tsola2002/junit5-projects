package com.tsola2002.datjpa;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.tsola2002.datjpa.entity.Student;
import java.time.LocalDate;
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

	@Autowired
	private ObjectMapper objectMapper;


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
				.andExpect(content().contentType(APPLICATION_JSON_UTF8))
				.andExpect(jsonPath("$", hasSize(3)));
	}



	@Test
	public void createStudentTest() throws Exception{

		Student student = new Student();

		student.setStudentId(8L);
		student.setStudentName("Ribadu");
		student.setDateOfBirth(LocalDate.of(1995, 7, 25));
		student.setStudentAddress("LEKKI");


		mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/students")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(student)))
						.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.studentName").value("Ribadu"));

	}

	@Test
	public void updateStudentTest() throws Exception {
		// Arrange - create the updated student data
		Student updatedStudent = new Student();
		updatedStudent.setStudentId(1L);
		updatedStudent.setStudentName("Updated Name");
		updatedStudent.setDateOfBirth(LocalDate.of(2000, 1, 1));
		updatedStudent.setStudentAddress("Updated Address");

		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/students/{id}", 1L)
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(updatedStudent)))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.studentName").value("Updated Name"))
				.andExpect(jsonPath("$.studentAddress").value("Updated Address"));
	}

	@Test
	void contextLoads() {
	}

	@Test
	public void deleteStudentTest() throws Exception {
		// Act & Assert
		mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/students/{id}", 1L))
				.andExpect(status().isOk());
	}

}
