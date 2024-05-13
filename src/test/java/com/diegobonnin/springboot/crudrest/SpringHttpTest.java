package com.diegobonnin.springboot.crudrest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import com.diegobonnin.springboot.crudrest.controllers.PodData;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class SpringHttpTest {

	private int port=8080;
	private ObjectMapper objectMapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void test() throws Exception {
		
		//retrieve
		
		ResponseEntity<PodData> retrieveResponse=restTemplate.getForEntity("http://localhost:" + port + "/api/k8s-test", PodData.class);
		assertTrue(retrieveResponse.getStatusCodeValue()==200);
		PodData _p=retrieveResponse.getBody();
		assertTrue(_p.getHostname()!=null);
		assertTrue(_p.getIp()!=null);
		assertTrue(_p.getAppVersion()!=null);
		System.out.println(objectMapper.writeValueAsString(_p));
		
	}
}