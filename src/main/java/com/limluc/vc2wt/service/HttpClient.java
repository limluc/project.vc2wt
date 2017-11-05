package com.limluc.vc2wt.service;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;

import java.net.URI;

public interface HttpClient {
    <T> ResponseEntity<T> getRequest(URI url, ParameterizedTypeReference<T> responseType);

    <T> ResponseEntity<T> getRequest(URI url, Class<T> responseType);
}
