package com.rest.template.service;

import com.rest.template.model.TestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * @author vector
 * @date: 2019/3/15 0015 9:26
 */
@Service
public class RestService {

    @Autowired
    private RestTemplate restTemplate;

    private static String HOST = "http://localhost:8080";

    private static String GET_URL = "/testGet";
    private static String POST_URL = "/testPost";
    private static String POST_PARAM_URL = "/testPostParam";
    private static String PUT_URL = "/testPut";
    private static String DEL_URL = "/testDel";


    public void get() throws URISyntaxException {

        ResponseEntity<TestDTO> responseEntity = this.restTemplate.getForEntity(HOST + GET_URL, TestDTO.class);
        System.out.println("getForEntity: " + responseEntity.getBody());

        TestDTO forObject = this.restTemplate.getForObject(HOST + GET_URL, TestDTO.class);
        System.out.println("getForObject: "+ forObject);

        RequestEntity<Void> requestEntity = RequestEntity.get(new URI(HOST + GET_URL)).build();
        ResponseEntity<TestDTO> exchange = this.restTemplate.exchange(requestEntity, TestDTO.class);
        System.out.println("exchange: "+ exchange.getBody());
    }
}
