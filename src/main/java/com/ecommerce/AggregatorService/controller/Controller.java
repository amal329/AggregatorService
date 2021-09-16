package com.ecommerce.AggregatorService.controller;

import com.ecommerce.AggregatorService.StudentDTO;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class Controller {

    List<StudentDTO> students;
    String url = "http://localhost:9091/student";

    public List<StudentDTO> getStudents(){
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        HttpEntity<StudentDTO[]> entity = new HttpEntity<>(headers);
        ResponseEntity<StudentDTO[]> response = template.exchange(url,
                HttpMethod.GET, entity, StudentDTO[].class);
        students = new ArrayList<>(Arrays.asList(response.getBody()));
        return students;
    }

}
