package com.Himanshu.TTN.SpringRestApiExample.Filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class FilterControll {




        @Autowired
        UserService service;

        //static-filtering for password
        @GetMapping(path = "/staticfilter/{id}")

        public User getEmployee(@PathVariable Integer id) {
            User user = service.findOne(id);
            return user;
        }

        //method to create user, accepts password too
        @PostMapping(path = "/staticfilter")

        public ResponseEntity<Object> createUser(@RequestBody User user) {
            User createdUser = service.save(user);

            URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId()).toUri();

            return ResponseEntity.created(location).build();
        }

        //method to print list of users
        @GetMapping(path = "/staticfilter/list")

        public List<User> getListOfUsers() {
            return service.findAll();
        }


        //DYNAMIC filtering
        @GetMapping(path = "/dynamicfilter/{id}")
        public MappingJacksonValue someUser(@PathVariable Integer id) {
            User user = service.findOne(id);
            SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("id", "username");
            FilterProvider filters = new SimpleFilterProvider().addFilter("SomeUserFilter", filter);
            MappingJacksonValue mapping = new MappingJacksonValue(user);
            mapping.setFilters(filters);
            return mapping;
        }
    }

