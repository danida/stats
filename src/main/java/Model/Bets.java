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
public class Bets {
      private List<Bet> bets = new ArrayList<>();

    public List<Bet> getBets() {
        return bets;
    }
    @XmlElement(name = "bet")
    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }
}
