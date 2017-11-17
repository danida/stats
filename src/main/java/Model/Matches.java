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
 * @author dnovak
 */
@XmlRootElement
public class Matches {
    private List<Match> matches = new ArrayList<>();

    public List<Match> getMatches() {
        return matches;
    }
    @XmlElement(name = "match")
    public void setMatches(List<Match> matches) {
        this.matches = matches;
    }
    
}
