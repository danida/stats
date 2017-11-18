/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danida
 */
@XmlRootElement

public class Teams {
        private List<Team> teams = new ArrayList<>();

    public List<Team> getTeams() {
        return teams;
    }
    @XmlElement(name = "team")
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
