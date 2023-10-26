package com.resourcium1.controllers;

import com.resourcium1.dao.ReservationDAO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReservationControllerTest {

    static String  url = null;

    @BeforeAll
    static void setUp() {
        url = "http://localhost:8080/Resourcium1_war_exploded/reservations";

    }


    @Test
    void doGet() throws Exception{
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(200, statusCode);


    }

    @Test
    void doPost() throws Exception{
        HttpClient httpClient = HttpClients.createDefault();


        // Create an HTTP POST request
        HttpPost postRequest = new HttpPost(url);

        // Define the request parameters
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("startDate", "2000-01-01 00:00:00"));
        params.add(new BasicNameValuePair("endDate", "2000-01-11 00:00:00"));
        params.add(new BasicNameValuePair("equipmentId", "1"));
        params.add(new BasicNameValuePair("employeeId", "1"));
        postRequest.setEntity(new UrlEncodedFormEntity(params));

        // Execute the POST request
        HttpResponse response = httpClient.execute(postRequest);

        // Get the HTTP response code
        int statusCode = response.getStatusLine().getStatusCode();

        // Perform assertions on the response code
        assertEquals(201, statusCode);
    }


    @AfterEach
    void tearDown() {
        ReservationDAO.deleteAll();
    }
}
