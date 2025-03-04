package com.Vitech.springFS.services.impl;

import com.Vitech.springFS.domain.PersonRequest;
import com.Vitech.springFS.domain.PersonResponse;
import com.Vitech.springFS.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    public List<PersonResponse> completePersonList(){
        return persons;

    }

    public PersonResponse findByDNI(String DNI ){
        //List<String> chosen_person_x =  persons_list.stream().map(Person::getDNI).collect(Collectors.toList());

        try {
            PersonResponse chosen_person = persons.stream()
                    .filter(PersonResponse -> DNI.equals(PersonResponse.getDNI()))
                    .findAny()
                    .orElse(null);
            return chosen_person;
        }catch (Exception e){
            e.printStackTrace();
            return null;

        }


    }

    public PersonResponse updateByDNI(String DNI , PersonResponse person){
        //List<String> chosen_person_x =  persons_list.stream().map(Person::getDNI).collect(Collectors.toList());
        PersonResponse personToUpdate = findByDNI(DNI);

        personToUpdate.setDNI(person.getDNI());
        personToUpdate.setName(person.getName());
        personToUpdate.setFirst_surname(person.getFirst_surname());
        personToUpdate.setSecond_surname(person.getSecond_surname());
        personToUpdate.setFull_name(person.getName()+ " " + person.getFirst_surname() + " " + person.getSecond_surname());
        personToUpdate.setBirthdate(person.getBirthdate());
        personToUpdate.setGender_sex(person.getGender_sex());

        return personToUpdate;
    }


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
                    "Hombre")

    ));

}
