package com.example.restful.utils;

import com.example.restful.VO.Address;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Converter {

    public Object fromJson(String jsonString, String ClassRef) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        JsonNode node = mapper.readTree(jsonString);
        System.out.println(node);

        String str = node.get("Address").toString();
        return mapper.readValue(str,Address.class);
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
