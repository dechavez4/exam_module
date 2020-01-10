/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.ArrayList;
import java.util.List;
import entities.Hobby;

/**
 *
 * @author Renz
 */
public class HobbiesDTO {

    List<HobbyDTO> all = new ArrayList<>();

    public HobbiesDTO(List<Hobby> hobbyEntities) {
        for (Hobby hobbyEntity : hobbyEntities) {
            all.add(new HobbyDTO(hobbyEntity));
        }
    }

    public List<HobbyDTO> getAll() {
        return all;
    }

    public void setAll(List<HobbyDTO> all) {
        this.all = all;
    }
    
}
