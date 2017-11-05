package com.limluc.vc2wt.service;

import com.limluc.vc2wt.exception.HttpClientException;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class HttpRestClient implements HttpClient {
    private final static Log LOG = LogFactory.getLog(HttpRestClient.class);

    private final RestTemplate restTemplate;


    @Autowired
    public HttpRestClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public <T> ResponseEntity<T> getRequest(URI url, ParameterizedTypeReference<T> responseType) {
        LOG.info(String.format("Executing GET request for [%s]", url.toString()));

        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        final HttpEntity<?> entity = new HttpEntity<>(headers);

        final ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, entity, responseType);

        isStatusOK(response);
        return response;
    }

    @Override
    public <T> ResponseEntity<T> getRequest(URI url, Class<T> clazz) {
        LOG.info(String.format("Executing GET request for [%s]", url.toString()));

        final HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        final HttpEntity<?> entity = new HttpEntity<>(headers);

        final ResponseEntity<T> response = restTemplate.exchange(url, HttpMethod.GET, entity, clazz);

        isStatusOK(response);
        return response;
    }

    private <T> void isStatusOK(ResponseEntity<T> response) {
        if (response.getStatusCode() != HttpStatus.OK) {
            throw new HttpClientException(String.format("Unable to retrieve response from Github [%s] : [%s]", response.getStatusCode(),
                    response.getBody()));
        }
    }
}
