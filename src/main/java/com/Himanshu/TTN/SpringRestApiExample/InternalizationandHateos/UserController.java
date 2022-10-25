package com.Himanshu.TTN.SpringRestApiExample.InternalizationandHateos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class UserController {
    private MessageSource messageSource;

    @Autowired
    private UserService service;


    public UserController(MessageSource messageSource)
    {
        this.messageSource=messageSource;
    }




    @GetMapping("/users")
    public List<User> getAll()
    {

        return service.findAll();
    }

    //getting Pathvariable
    //Implement GET
    // http request using path variable top get one employee
    //HATEOS
    //content negotiation
    @GetMapping("/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id) throws IdNotFoundException {
        User user = service.findOne(id);

        //throwing exception when id is not found
        if(user==null)
            throw new IdNotFoundException("id:"+id);


        //using entity model
        // represents RepresentationModel containing only single entity and related links
        EntityModel<User> entityModel = EntityModel.of(user);
        //we can use WebMvcLinkBuilder to create links pointing to controller classes and it’s methods.
        WebMvcLinkBuilder link =  linkTo(methodOn(this.getClass()).getAll());
        // adding link
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }
    @GetMapping(path="/hello")
    public String helloNameInterNationalized()
    {
        //requestheader
        Locale locale= LocaleContextHolder.getLocale();
        return messageSource.getMessage("hello.name.message",null,"Default message",locale);
    }





    //DELETE
    @DeleteMapping(path="/users/{id}")
    public void delete(@PathVariable int id )
    {


        //deleting
        service.delete(id);

    }

    //content negotiation
    //Apply validation while
    // create a new employee using POST http Request.
    // create user

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        service.delete(id);
    }









}

