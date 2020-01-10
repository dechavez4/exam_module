/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Address;
import java.util.Objects;

/**
 *
 * @author Renz
 */
public class AddressDTO {
    private Integer id;
    private String street;
    private String city;
    private int zip;
    
   public AddressDTO(){
       
   }
   
   public AddressDTO(Address address){
       if(address.getId() != null){
           this.id = address.getId();
       }
       this.street = address.getStreet();
       this.zip = address.getZip();
   }

    public Integer getId() {
        return id;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public int getZip() {
        return zip;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AddressDTO other = (AddressDTO) obj;
        if (this.zip != other.zip) {
            return false;
        }
        if (!Objects.equals(this.street, other.street)) {
            return false;
        }
        if (!Objects.equals(this.city, other.city)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "AddressDTO{" + "id=" + id + ", street=" + street + ", city=" + city + ", zip=" + zip + '}';
    }
}
