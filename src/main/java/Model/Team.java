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
public class Team {
    private int id;
    private String name;
    private String imageurl;
    private String fixturesurl;

    public Team() {
    }

    
    public Team(int id, String name, String imageurl, String fixturesurl) {
        this.id = id;
        this.name = name;
        this.imageurl = imageurl;
        this.fixturesurl = fixturesurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getFixturesurl() {
        return fixturesurl;
    }

    public void setFixturesurl(String fixturesurl) {
        this.fixturesurl = fixturesurl;
    }
    
    
    
}
