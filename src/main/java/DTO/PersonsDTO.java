/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Renz
 */
public class PersonsDTO {

    List<PersonDTO> all = new ArrayList<>();

    public PersonsDTO(List<Person> personEntities) {
        for (Person personEntity : personEntities) {
            all.add(new PersonDTO(personEntity));
        }
    }

    public List<PersonDTO> getAll() {
        return all;
    }

    public void setAll(List<PersonDTO> all) {
        this.all = all;
    }
    

}
