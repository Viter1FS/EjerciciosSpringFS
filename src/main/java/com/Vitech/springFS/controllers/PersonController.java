package com.Vitech.springFS.controllers;


import com.Vitech.springFS.domain.PersonRequest;
import com.Vitech.springFS.domain.PersonResponse;
import com.Vitech.springFS.services.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Definimos la clase como un controlador REST que maneja las solicitudes HTTP
@RestController
public class PersonController {

    // Inyectamos el servicio PersonService para manejar la lógica de negocio relacionada con las personas
    @Autowired
    public PersonService personService;


    // Método para obtener todas las personas
    // Mapea las solicitudes GET a la ruta "/persons"
    @GetMapping("/persons")
    public List<PersonResponse> getAllPersons(){
        return personService.completePersonList();
    }

    // Método para obtener una persona específica usando su DNI
    // Mapea las solicitudes GET a la ruta "/persons/{DNI}" donde {DNI} es un parámetro de la URL
    @GetMapping("/persons/{DNI}")
    public PersonResponse getPersonBydni (@PathVariable String DNI){
        // Llama al servicio para buscar la persona por su DNI y devolvemos lapersona encontrada
        PersonResponse personByDNI = personService.findByDNI(DNI);
        System.out.println(personByDNI.toString());
        return personByDNI;
    }


    // Método para agregar una nueva persona
    // Mapea las solicitudes POST a la ruta "/addPerson"
    // @RequestParam se utiliza para obtener los parámetros del cuerpo de la solicitud
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



    // Método para actualizar una persona existente usando su DNI
    // Mapea las solicitudes PUT a la ruta "/persons/{DNI}" donde {DNI} es un parámetro de la URL
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



