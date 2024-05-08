package com.example.afformed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@Service
public class ECommereceService {


    @Autowired
    private RestTemplate restTemplate;

    private final String BASE_URL = "http://20.244.56.144/test";



    public List<Product> getTopProducts(String company, String category, int top, int minPrice, int maxPrice) {
        String accessToken="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJNYXBDbGFpbXMiOnsiZXhwIjoxNzE1MTY4NDQ2LCJpYXQiOjE3MTUxNjgxNDYsImlzcyI6IkFmZm9yZG1lZCIsImp0aSI6IjhkZjkyZTllLTc0YTktNGFmNC1hNDNjLWNiYjk4NTg3OWYzNiIsInN1YiI6InN1cnlhc2FuamF5MzIxQGdtYWlsLmNvbSJ9LCJjb21wYW55TmFtZSI6IlBTTkEgQ29sbGVnZSBvZiBFbmdpbmVlcmluZyBhbmQgdGVjaG5vbG9neSIsImNsaWVudElEIjoiOGRmOTJlOWUtNzRhOS00YWY0LWE0M2MtY2JiOTg1ODc5ZjM2IiwiY2xpZW50U2VjcmV0IjoiZHJkaU1VcHdDZWVOYUhzYyIsIm93bmVyTmFtZSI6IlN1cnlhIE0iLCJvd25lckVtYWlsIjoic3VyeWFzYW5qYXkzMjFAZ21haWwuY29tIiwicm9sbE5vIjoiOTIxMzIxMjA1MTY1In0.M7pRd4PLx0JcAgT2-C0bem9DeFCUY0soLswVSLhBtIs";
        String url = BASE_URL + "/companies/{company}/categories/{category}/products";
        System.out.println(url);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url)
                .queryParam("top", top)
                .queryParam("minPrice", minPrice)
                .queryParam("maxPrice", maxPrice);

        System.out.print(builder.toUriString());
        url = builder.buildAndExpand("AMZ", "Laptop").toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken);
        HttpEntity<String> entity = new HttpEntity<>(headers);


        ResponseEntity<List<Product>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity,
                new ParameterizedTypeReference<List<Product>>() {});

        return responseEntity.getBody();
    }

}
