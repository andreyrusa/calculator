package com.sanitas.calculator;

import com.sanitas.calculator.model.OperationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

@SpringBootTest
@AutoConfigureMockMvc
class CalculatorApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	public void testSum() throws Exception {
		this.mockMvc.perform(post("/v1/api/calculate/sum")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new OperationRequest(new BigDecimal(2.0), new BigDecimal(3.0)))))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.result", is(5)))
				.andExpect(jsonPath("$.operation", is("sum")))
				.andExpect(jsonPath("$.operand1", is(2)))
				.andExpect(jsonPath("$.operand2", is(3)));
	}

	@Test
	public void testSubtract() throws Exception {
		this.mockMvc.perform(post("/v1/api/calculate/subtract")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(new OperationRequest(new BigDecimal(3.0), new BigDecimal(2.0)))))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.result", is(1)))
				.andExpect(jsonPath("$.operation", is("subtract")))
				.andExpect(jsonPath("$.operand1", is(3)))
				.andExpect(jsonPath("$.operand2", is(2)));
	}


	@Test
	public void testSumWithoutOperands() throws Exception {
		OperationRequest request = new OperationRequest();
		this.mockMvc.perform(post("/v1/api/calculate/sum")
						.contentType(MediaType.APPLICATION_JSON)
						.content(objectMapper.writeValueAsString(request)))
				.andExpect(status().isBadRequest())
				.andExpect(jsonPath("$.status", is(HttpStatus.BAD_REQUEST.value())))
				.andExpect(jsonPath("$.message", is("Los operandos no pueden ser nulos")));
	}
}
