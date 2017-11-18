/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danida
 */

@XmlRootElement

public class Bet {
    public enum BetType {goal,x12, scores};
    
    private int id;
    private Match match;
    private BetType bet;
    private Double odds;
    private boolean win;

    public Bet(Match match, BetType bet, Double odds, boolean win) {
        this.match = match;
        this.bet = bet;
        this.odds = odds;
        this.win = win;
    }

    public Bet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public BetType getBet() {
        return bet;
    }

    public void setBet(BetType bet) {
        this.bet = bet;
    }

    public Double getOdds() {
        return odds;
    }

    public void setOdds(Double odds) {
        this.odds = odds;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }
    
    
    
}
