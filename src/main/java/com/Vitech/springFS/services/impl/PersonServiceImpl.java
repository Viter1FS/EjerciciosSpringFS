package com.Vitech.springFS.services.impl;

import com.Vitech.springFS.domain.PersonRequest;
import com.Vitech.springFS.domain.PersonResponse;
import com.Vitech.springFS.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// La clase PersonServiceImpl está marcada con la anotación @Service para indicar que es un servicio de Spring
@Service
public class PersonServiceImpl implements PersonService {

    // Método para obtener la lista completa de personas
    public List<PersonResponse> completePersonList(){
        return persons;

    }

    // Método para buscar una persona por su DNI
    public PersonResponse findByDNI(String DNI ){
        //List<String> chosen_person_x =  persons_list.stream().map(Person::getDNI).collect(Collectors.toList());
        try {
            // Utiliza el stream para buscar una persona cuyo DNI coincida con el proporcionado
            PersonResponse chosen_person = persons.stream()
                    .filter(person -> DNI.equals(person.getDNI())) // Filtra por el DNI
                    .findAny()  // Busca cualquier persona que cumpla la condición
                    .orElse(null); // Devuelve null si no encuentra ninguna persona
            return chosen_person;
        }catch (Exception e){
            // Si ocurre algún error, imprime la excepción y devuelve null
            e.printStackTrace();
            return null;
        }


    }

    // Método para actualizar los datos de una persona utilizando su DNI
    public PersonResponse updateByDNI(String DNI , PersonResponse person){
        //List<String> chosen_person_x =  persons_list.stream().map(Person::getDNI).collect(Collectors.toList());
        // Primero, busca la persona que tiene el DNI proporcionado
        PersonResponse personToUpdate = findByDNI(DNI);

        // Si la persona existe, se actualizan sus datos con la información proporcionada
        personToUpdate.setDNI(person.getDNI());
        personToUpdate.setName(person.getName());
        personToUpdate.setFirst_surname(person.getFirst_surname());
        personToUpdate.setSecond_surname(person.getSecond_surname());
        personToUpdate.setFull_name(person.getName()+ " " + person.getFirst_surname() + " " + person.getSecond_surname());
        personToUpdate.setBirthdate(person.getBirthdate());
        personToUpdate.setGender_sex(person.getGender_sex());

        return personToUpdate;
    }


    // Lista de personas predefinida para simular una base de datos
    private List<PersonResponse> persons = new ArrayList<>(Arrays.asList(
            new PersonResponse(
                    "50371409Y",
                    "David" ,
                    "Buenaño" ,
                    "Viteri" ,
                    "27/06/1993" ,
                    "Hombre"),
            new PersonResponse(
                    "X512365Y",
                    "Pepe" ,
                    "Escobar" ,
                    "Gaviria" ,
                    "27/06/1983" ,
                    "Hombre"),
            new PersonResponse(
                    "X512366Y",
                    "Paco Peco" ,
                    "Escobar" ,
                    "Gaviria" ,
                    "27/06/1986" ,
                    "Hombre"),
            new PersonResponse(
                    "X512361Y",
                    "Paco Peco" ,
                    "Ramirez" ,
                    "Ziro" ,
                    "27/06/1986" ,
                    "Hombre"),
            new PersonResponse(
                    "X522366Y",
                    "Peco" ,
                    "Lopez" ,
                    "Zanetti" ,
                    "27/06/1986" ,
                    "Hombre"),
            new PersonResponse(
                    "X532366Y",
                    "Pablo" ,
                    "Ramirez" ,
                    "Pochetino" ,
                    "27/06/1986" ,
                    "Hombre"),
            new PersonResponse(
                    "X542366Y",
                    "Luis" ,
                    "Lopez" ,
                    "Chingasu" ,
                    "27/06/1946" ,
                    "Hombre"),
            new PersonResponse(
                    "X552366Y",
                    "Alma" ,
                    "Marcela" ,
                    "Gozo" ,
                    "27/06/1986" ,
                    "Mujer"),
            new PersonResponse(
                    "X562366Y",
                    "Elena" ,
                    "Nito" ,
                    "Del bosque" ,
                    "27/06/1986" ,
                    "Mujer"),
            new PersonResponse(
                    "X572366Y",
                    "Luz" ,
                    "Cuesta" ,
                    "Mazo" ,
                    "27/06/1986" ,
                    "Mujer")

    ));

}
