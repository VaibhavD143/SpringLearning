package com.example.restful.contoller;

import com.example.restful.VO.Address;
import com.example.restful.repository.AddressRepository;
import com.example.restful.repository.EmployeeRepository;
import com.example.restful.utils.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import jdk.nashorn.internal.ir.ObjectNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("address/")
public class AddressController {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping("/getAll")
    public List<Address> getAddresses(){
        return addressRepository.findAll();
    }

    @GetMapping("/getOne")
    public Address getAddress(@RequestParam Integer id){
        return addressRepository.getOne(id);
//        return addressRepository.findById(id);
    }

    @PostMapping("/insert")
    public Address createAddress(@Valid @RequestBody Address address) {
        return addressRepository.save(address);
    }

    @GetMapping("/testNode")
    public JsonNode testNode() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<Address> add =  addressRepository.findAll();

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
//        mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);

        JsonNode node = mapper.valueToTree(add);
        return node;
    }
    @GetMapping("/testString")
    public String testString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
//        Optional<Address> add = addressRepository.findById(1);
        List<Address> add = addressRepository.findAll();

        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
//        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS,false);
//        mapper.registerModule(new JavaTimeModule());

//        String node = mapper.writeValueAsString(add.get());
        String node = mapper.writer().withRootName("Addresses").writeValueAsString(add);
        //        System.out.println(node);
        return node;
    }

    @GetMapping("/testJsonList")
    public String testJsonList() throws JsonProcessingException {
        Address address = addressRepository.getOne(1);
        String jsonString= (new Converter()).toJson(address,"Address");
        return (new Converter()).toJson(address,"Addresses",jsonString);
    }

    @GetMapping("/testJsonListAll")
    public String testJsonListAll() throws JsonProcessingException {
        List<Address> addresses = addressRepository.findAll();
        String jsonString= (new Converter()).toJson(addresses,"Address");
        return (new Converter()).toJson(addresses,"Addresses",jsonString);
    }

    @GetMapping("/testJson")
    public String testJson() throws JsonProcessingException {
        Address address = addressRepository.getOne(1);
        String jsonString= (new Converter()).toJson(address,"Address");
        return jsonString;
    }

    @GetMapping("/testJsonAll")
    public String testJsonAll() throws JsonProcessingException {
        List<Address> addresses = addressRepository.findAll();
        return (new Converter()).toJson(addresses,"Addresses");
    }

    @PostMapping("/testFJsonAll")
    public List<Address> testFJsonAll(@RequestBody String node) throws JsonProcessingException {
        System.out.println(node);
        List<Address> addresses = (new Converter()).fromJsonList(node, "Addresses", Address[].class);
        return addresses;
    }
    @PostMapping("/testFJson")
    public Address testFJson(@RequestBody String node) throws JsonProcessingException {
        Address address = (Address) (new Converter()).fromJson(node, "Address", Address.class);
        return address;
    }

}
