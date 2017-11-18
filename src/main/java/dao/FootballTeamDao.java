/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Team;
import Model.Teams;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;
import javax.xml.bind.Unmarshaller;



/**
 *
 * @author danida
 */
public class FootballTeamDao {
    public void insert(Team t) {
        Teams teams = new Teams();
        FileInputStream fis = null;
        File file = new File("teams.xml");
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(FootballTeamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Teams.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            teams = (Teams) unmarshaller.unmarshal(new File("teams.xml"));
            fis.close();
        } catch (JAXBException ex) {
            Logger.getLogger(FootballTeamDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FootballTeamDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            JAXBContext context = JAXBContext.newInstance(Teams.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            List<Team> l = teams.getTeams();
            int id = getBiggestId(l);
            t.setId(id + 1);
            l.add(t);
            teams.setTeams(l);
            m.marshal(teams, new File("teams.xml"));

        } catch (PropertyException ex) {
            Logger.getLogger(FootballTeamDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(FootballTeamDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public void delete(int id) {
        Teams teams = new Teams();
        Team ret = new Team();
        FileInputStream fis = null;
        File file = new File("teams.xml");
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FootballTeamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Teams.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            teams = (Teams) unmarshaller.unmarshal(new File("teams.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(FootballTeamDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator it = teams.getTeams().iterator();
        while (it.hasNext()) {
            Team match = (Team) it.next();
            if (match.getId() == id) {
                it.remove();
            }
        }

    }

    public Team get(int id) {
        Teams teams = new Teams();
        Team ret = new Team();
        FileInputStream fis = null;
        File file = new File("teams.xml");
        try {
            fis = new FileInputStream(file);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FootballTeamDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(Teams.class
            );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            teams = (Teams) unmarshaller.unmarshal(new File("teams.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(FootballTeamDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        for (Team m : teams.getTeams()) {
            if (m.getId() == id) {
                ret = m;
            }

        }
        return ret;
    }

    public List<Team> getAll() {

        Teams teams = new Teams();
        FileInputStream fis = null;
        File file = new File("teams.xml");
        try {
            fis = new FileInputStream(file);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FootballTeamDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(Teams.class
            );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            teams = (Teams) unmarshaller.unmarshal(new File("teams.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(FootballTeamDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return teams.getTeams();
    }

    public Team findTeamByName(String name){
    
     Teams teams = new Teams();
        FileInputStream fis = null;
        File file = new File("teams.xml");
        try {
            fis = new FileInputStream(file);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(FootballTeamDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(Teams.class
            );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            teams = (Teams) unmarshaller.unmarshal(new File("teams.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(FootballTeamDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        Team team = new Team();
        for (Team t : teams.getTeams()){
            if (t.getName().toLowerCase().contains(name.toLowerCase())){
                team = t;
            
            }
        
        
        }
        return team;
    
    }
    
    private int getBiggestId(List<Team> l) {
        int max = 0;
        for (Team m : l) {
            if (m.getId() > max) {
                max = m.getId();
            }

        }
        return max;
    }
}
