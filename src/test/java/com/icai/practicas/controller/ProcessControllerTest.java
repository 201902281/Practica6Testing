package com.icai.practicas.controller;


import com.icai.practicas.controller.ProcessController.DataRequest;
import com.icai.practicas.controller.ProcessController.DataResponse;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.assertj.core.api.BDDAssertions.then;





@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProcessControllerTest {
    
    @LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

    //@Autowired
	//private MockMvc mockMvc;

    @Test
    public void process_data_then_ok(){
        //Given
		String address = "http://localhost:" + port + "/api/v1/process-step1";
        DataRequest data = new DataRequest("Ignacio García", "53857194A", "628389354");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(data, headers);

        //When
		ResponseEntity<DataResponse> result = this.restTemplate.postForEntity(address, request, DataResponse.class);

        //Then
		String expectedResult = "OK";
		DataResponse expectedResponse = new DataResponse(expectedResult);

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody().result()).isEqualTo(expectedResult);
		then(result.getBody()).isEqualTo(expectedResponse);
    }

    @Test 
    public void process_data_using_bad_parameters_then_ko() {
        //Given
		String address = "http://localhost:" + port + "/api/v1/process-step1";
        DataRequest data = new DataRequest("Ignacio García", "5385719-", "6283354");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<ProcessController.DataRequest> request = new HttpEntity<>(data, headers);

        //When
        ResponseEntity<DataResponse> result = this.restTemplate.postForEntity(address, request, DataResponse.class);

        //then
        String expectedResult = "KO";
		DataResponse expectedResponse = new DataResponse(expectedResult);

        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody().result()).isEqualTo(expectedResult);
		then(result.getBody()).isEqualTo(expectedResponse);
    }

    @Test
    public void process_data_legacy_then_ok () throws Exception{
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        MultiValueMap<String, String> data = new LinkedMultiValueMap<String,String>();
        data.add("fullName","Ignacio García");
        data.add("dni","53857194A");
        data.add("telefono","628389354");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data,headers);

        //When
        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        //then
        String expectedResult = ResponseHTMLGenerator.message1;
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(expectedResult);
    }


    @Test
    public void process_data_legacy_then_ko () throws Exception{
        //Given
        String address = "http://localhost:" + port + "/api/v1/process-step1-legacy";
        MultiValueMap<String, String> data = new LinkedMultiValueMap<String,String>();
        data.add("fullName","Ignacio García");
        data.add("dni","538194A");
        data.add("telefono","6283893PW");
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data,headers);

        //When
        ResponseEntity<String> result = this.restTemplate.postForEntity(address, request, String.class);

        //then
        String expectedResult = ResponseHTMLGenerator.message2;
        then(result.getStatusCode()).isEqualTo(HttpStatus.OK);
        then(result.getBody()).isEqualTo(expectedResult);
    }
}
