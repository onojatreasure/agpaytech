package com.example.demo.implementation;

import com.example.demo.response.CountriesResponse;
import com.example.demo.service.CountriesService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class CountriesServiceImpl implements CountriesService {

    @Value("classpath:countries.json")
    Resource resource;

    @Override
    public List<CountriesResponse> getSystemsCountries() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> data = null;
        try {
            data = mapper.readValue(new File("src/main/resources/countries.json"), new TypeReference<List<Map<String, Object>>>() {
            });
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        List<CountriesResponse> list = new ArrayList<>();
        for (Map map : data) {
            list.addAll(map.values());
        }
        return list;
    }
}
