package com.resourcium1.controllers;


import com.resourcium1.dao.EquipmentDAO;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EquipmentControllerTest {
    static String  url = null;

    @BeforeAll
    static void setUp(){

        // Define the URL of your servlet
        url = "http://localhost:8080/Resourcium1_war_exploded/equipments";
    }

    @Test
    void doPost() throws Exception {

        HttpClient httpClient = HttpClients.createDefault();


        // Create an HTTP POST request
        HttpPost postRequest = new HttpPost(url);

        // Define the request parameters
        List<BasicNameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("name", "value1"));
        params.add(new BasicNameValuePair("type", "value2"));
        postRequest.setEntity(new UrlEncodedFormEntity(params));

        // Execute the POST request
        HttpResponse response = httpClient.execute(postRequest);

        // Get the HTTP response code
        int statusCode = response.getStatusLine().getStatusCode();

        // Perform assertions on the response code
        assertEquals(201, statusCode);


    }

    @Test
    void doGet() throws Exception {
        HttpClient httpClient = HttpClients.createDefault();
        HttpGet request = new HttpGet(url);
        HttpResponse response = httpClient.execute(request);
        int statusCode = response.getStatusLine().getStatusCode();
        assertEquals(200, statusCode);
    }

    @AfterAll
    static void tearsDown(){
        EquipmentDAO.deleteAll();
    }

}