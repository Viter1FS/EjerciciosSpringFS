package com.Vitech.springFS.controllers;

import com.Vitech.springFS.beans.Person;
import com.Vitech.springFS.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class PersonController {

    @Autowired
    public PersonService personService;



    @GetMapping("/persons")
    public List<Person> getAllPersons(){
        return personService.completePersonList();
    }

    @GetMapping("/persons/{DNI}")
    public Person getPersonBydni (@PathVariable String DNI){
        Person personByDNI = personService.findByDNI(DNI);
        System.out.println(personByDNI.toString());
        return personByDNI;
    }


    @PostMapping("/addPerson")
    public Person postPerson(@RequestParam String DNI,
                             @RequestParam String name,
                             @RequestParam String first_surname ,
                             @RequestParam String second_surname,
                             @RequestParam String birthdate,
                             @RequestParam String gender_sex){
        Person personPost = new Person(DNI,name,first_surname,second_surname,birthdate,gender_sex);
        personService.completePersonList().add(personPost);
        return personPost;
    }

    @PutMapping("/persons/{DNI}")
    public Person putPersonBydni (@PathVariable String DNI ,
                                  @RequestBody Person personRequest){
        try{
            personRequest = personService.updateByDNI(DNI ,personRequest);
            System.out.println(personRequest.toString());
            return personRequest;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }



    }




    /*
    @PostMapping("/addPerson")
    public Person postPerson(@RequestParam String name,
                             @RequestParam String first_surname ,
                             @RequestParam String second_surname,
                             @RequestParam String birthdate,
                             @RequestParam String gender_sex){
        Person personPost = new Person(name,first_surname,second_surname,birthdate,gender_sex);
        persons.add(personPost);
        return personPost;
    }
    */



}



