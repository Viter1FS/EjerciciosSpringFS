package com.Vitech.springFS.services;

import com.Vitech.springFS.domain.PersonRequest;
import com.Vitech.springFS.domain.PersonResponse;

import java.util.List;



public interface PersonService {


    public List<PersonResponse> completePersonList();
    public PersonResponse findByDNI(String DNI );
    public PersonResponse updateByDNI(String DNI , PersonResponse person);

}
