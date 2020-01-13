/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import DTO.HobbiesDTO;
import DTO.HobbyDTO;
import DTO.PersonDTO;
import entities.Address;
import entities.Hobby;
import entities.Person;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;

/**
 *
 * @author Renz
 */
public class GeneralFacade {

    private static GeneralFacade instance;
    private static EntityManagerFactory emf;

    public static GeneralFacade getGeneralFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new GeneralFacade();
        }
        return instance;
    }
//adding person
    public PersonDTO addPerson(PersonDTO person) {
        EntityManager em = emf.createEntityManager();
        Person p = new Person(person.getEmail(), person.getFirstName(), person.getLastName(), person.getPhone());
        System.out.println("person p:" + p);
        
        Address a = new Address(person.getAddress().getStreet(), person.getAddress().getCity(), person.getAddress().getZip());
        p.setAddress(a);
        System.out.println("person p:" + a);
        //grunden til vi looper igennem er fordi vi arbejder med 
        //en liste af hobbier. 
        for (HobbyDTO h : person.getHobbies()) {
            String name = h.getName();
            String pDesc = h.getDescription();
            Hobby hobby = new Hobby(name, pDesc);
            System.out.println("Hobby" +  hobby);
            p.setHobbies(hobby);
        }
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(p);
    }
    
     public PersonDTO getAllPersonsByHobby(String name) {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery("SELECT p FROM Person p JOIN p.hobbies h WHERE h.name = :hobbyName", Person.class);

            List<Person> list = query.setParameter("hobbyName", name).getResultList();

            return new PersonDTO((Person) list);
        } finally {
            em.close();
        }
    }

    
//get all hobbies
    public HobbiesDTO getAllHobbies(){
        EntityManager em = emf.createEntityManager();
        try{
            List<Hobby> list = em.createQuery("SELECT h FROM Hobby h", Hobby.class).getResultList();
            return new HobbiesDTO(list);
        }finally{
            em.close();
        }
    }
//remove a hobby
    
//edit a hobby
    
    
}
