/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import DTO.HobbyDTO;
import DTO.PersonDTO;
import DTO.PersonsDTO;
import entities.Address;
import entities.Hobby;
import entities.Person;
import facades.GeneralFacade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;
import utils.SetupTestUsers;

/**
 *
 * @author Renz
 */
@Path("general")
public class GeneralResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
            "pu",
            "jdbc:mysql://localhost:3307/exam_prep",
            "dev",
            "ax2",
            EMF_Creator.Strategy.CREATE);
    private static final GeneralFacade FACADE = GeneralFacade.getGeneralFacade(EMF);
    private static SetupTestUsers add = new SetupTestUsers();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getInfoForAll() {
        return "{\"msg\":\"Hello user from General\"}";
    }

    @Path("setup")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public PersonDTO setup() {
        Person p1 = new Person("Hans@hansen.com", "Hans", "hansen", "12345678");
        Address a1 = new Address("amager", "københavn", 2300);
        Hobby h1 = new Hobby("fodbold", "test bold");
        p1.setAddress(a1);
        p1.setHobbies(h1);

        PersonDTO pDTO = new PersonDTO(p1);
        return FACADE.addPerson(pDTO);
    }

    @Path("fill")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String fill() {
        add.fill();
        return "setup complete";
    }

    @Path("/all/hobby/{name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<PersonDTO> getAllPersonsByHobby(String name) {
        return FACADE.getAllPersonsByHobby(name).getAll();
    }
    
    @GET
    @Path("all/hobby")
    @Produces(MediaType.APPLICATION_JSON)
    public List<HobbyDTO> getAllHobbies(){
        return FACADE.getAllHobbies().getAll();
    }
    
    //methods for person only
    @GET
    @Path("all/person")
    @Produces(MediaType.APPLICATION_JSON)
    public List getAllperson(){
        return FACADE.getAllPerson().getAll();
    }
    
    @GET
    @Path("all/person/id/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public PersonDTO getPersonByID(@PathParam("id") int id){
     return FACADE.getPersonById(id);
    }
    
}
