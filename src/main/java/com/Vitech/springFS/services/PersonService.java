package com.Vitech.springFS.services;

import com.Vitech.springFS.beans.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@Service
public class PersonService {



    public List<Person> completePersonList(){
        return persons;

    }

    public Person findByDNI(String DNI ){
        //List<String> chosen_person_x =  persons_list.stream().map(Person::getDNI).collect(Collectors.toList());
        Person chosen_person = persons.stream()
                .filter(Person -> DNI.equals(Person.getDNI()))
                .findAny()
                .orElse(null);


        return chosen_person;
    }

    public Person updateByDNI(String DNI , Person person){
        //List<String> chosen_person_x =  persons_list.stream().map(Person::getDNI).collect(Collectors.toList());
        Person personToUpdate = findByDNI(DNI);

        personToUpdate.setDNI(person.getDNI());
        personToUpdate.setName(person.getName());
        personToUpdate.setFirst_surname(person.getFirst_surname());
        personToUpdate.setSecond_surname(person.getSecond_surname());
        personToUpdate.setFull_name(person.getName()+ " " + person.getFirst_surname() + " " + person.getSecond_surname());
        personToUpdate.setBirthdate(person.getBirthdate());
        personToUpdate.setGender_sex(person.getGender_sex());



        return personToUpdate;
    }


    private List<Person> persons = new ArrayList<>(Arrays.asList(
            new Person(
                    "50371409Y",
                    "David" ,
                    "Buenaño" ,
                    "Viteri" ,
                    "27/06/1993" ,
                    "Hombre"),
            new Person(
                    "X512365Y",
                    "Pepe" ,
                    "Escobar" ,
                    "Gaviria" ,
                    "27/06/1983" ,
                    "Hombre"),
            new Person(
                    "X512366Y",
                    "Paco Peco" ,
                    "Escobar" ,
                    "Gaviria" ,
                    "27/06/1986" ,
                    "Hombre")

    ));


}
