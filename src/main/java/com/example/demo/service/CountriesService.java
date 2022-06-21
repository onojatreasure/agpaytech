package com.example.demo.service;

import com.example.demo.response.CountriesResponse;

import java.io.IOException;
import java.util.List;

public interface CountriesService {
    List<CountriesResponse> getSystemsCountries() throws IOException;
}
