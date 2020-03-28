package com.example.restful.utils;

import com.example.restful.VO.Address;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {

    public List<Address> fromJsonList(String jsonString, String key, java.lang.Class T) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        JsonNode node = mapper.readTree(jsonString);
        System.out.println("---------------------------");
        String str = node.get(key).toString();
        List<Address> addresses = mapper.readValue(str, new TypeReference<List<Address>>() {});
        return addresses;
    }

    public Object fromJson(String jsonString, String key, java.lang.Class T) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        JsonNode node = mapper.readTree(jsonString);
        String str = node.get(key).toString();
        System.out.println(str);
        return mapper.readValue(str,T);
    }

    public String toJson(Object object,String key) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return mapper.writer().withRootName(key).writeValueAsString(object);
    }

    public String toJson(List<Object> objects, String key) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        return mapper.writer().withRootName(key).writeValueAsString(objects);
    }

    public String toJson(Object object, String key, String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        Map<String,Object> map1 = mapper.readValue(jsonString, new TypeReference<HashMap<String, Object>>() {});
        Map<String,Object> map2 = mapper.readValue(this.toJson(object,key), new TypeReference<HashMap<String, Object>>() {});
        map1.putAll(map2);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map1); //Done


//        Map<String,Object> map = mapper.readValue(jsonString, new TypeReference<HashMap<String, Object>>() {});
//        map.put(key,mapper.writeValueAsString(object));
//        System.out.println(map.get("Address"));
//        System.out.println(mapper.writeValueAsString(object));
//        System.out.println(map.get("Addresses"));
//        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map); //1st me escape sequences


    }

    public String toJson(List<Object> objects, String key, String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        Map<String,Object> map1 = mapper.readValue(jsonString, new TypeReference<HashMap<String, Object>>() {});
        Map<String,Object> map2 = mapper.readValue(this.toJson(objects,key), new TypeReference<HashMap<String, Object>>() {});
        map1.putAll(map2);
        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(map1); //Done
    }

//    public String toJson(Object object, String key, String jsonString) throws JsonProcessingException {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//
//        ObjectNode node = mapper.createObjectNode();
//        node.put(key,mapper.writeValueAsString(object));
//        node.putObject(jsonString);
//
//        return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(node);
//
//    }
}
