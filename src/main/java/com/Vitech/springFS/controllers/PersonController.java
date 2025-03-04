package com.Vitech.springFS.controllers;


import com.Vitech.springFS.domain.PersonRequest;
import com.Vitech.springFS.domain.PersonResponse;
import com.Vitech.springFS.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    public PersonService personService;



    @GetMapping("/persons")
    public List<PersonResponse> getAllPersons(){
        return personService.completePersonList();
    }

    @GetMapping("/persons/{DNI}")
    public PersonResponse getPersonBydni (@PathVariable String DNI){
        PersonResponse personByDNI = personService.findByDNI(DNI);
        System.out.println(personByDNI.toString());
        return personByDNI;
    }


    @PostMapping( "/addPerson")
    public PersonResponse postPerson(@Valid @RequestParam String DNI,
                                    @RequestParam String name,
                                    @RequestParam String first_surname ,
                                    @RequestParam String second_surname,
                                    @RequestParam String birthdate,
                                    @RequestParam String gender_sex){
        PersonResponse personPost = new PersonResponse(DNI,name,first_surname,second_surname,birthdate,gender_sex);
        personService.completePersonList().add(personPost);
        return personPost;
    }

    @PutMapping("/persons/{DNI}")
    public PersonResponse putPersonBydni (@PathVariable String DNI ,
                                  @RequestBody PersonResponse PersonResponse){
        try{
            PersonResponse = personService.updateByDNI(DNI ,PersonResponse);
            System.out.println(PersonResponse.toString());
            return PersonResponse;
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



