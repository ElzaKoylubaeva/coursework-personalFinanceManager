package ru.koylubaevaem.netology.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.koylubaevaem.netology.model.Purchase;
import ru.koylubaevaem.netology.model.Response;

public class MappingService {

    private ObjectMapper objectMapper = new ObjectMapper();

    public MappingService() {
        objectMapper.registerModule(new JavaTimeModule());
    }

    public Purchase deserialize(String json) {
        Purchase purchase = null;
        try {
            purchase = objectMapper.readValue(json, Purchase.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return purchase;
    }

    public String serialize(Response response) {
        String json = null;
        try {
            json = objectMapper.writeValueAsString(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
