/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Match;
import Model.Matches;
import dao.interfaces.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
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
 * @author dnovak
 */
public class MatchDao implements dao<Match> {

    @Override
    public void insert(Match t) {
        Matches matchs = new Matches();
        FileInputStream fis = null;
        File file = new File("matches.xml");
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Matches.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            matchs = (Matches) unmarshaller.unmarshal(new File("matches.xml"));
            fis.close();
        } catch (JAXBException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            JAXBContext context = JAXBContext.newInstance(Matches.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            List<Match> l = matchs.getMatches();
            int id = getBiggestId(l);
            t.setId(id + 1);
            l.add(t);
            matchs.setMatches(l);
            m.marshal(matchs, new File("matches.xml"));

        } catch (PropertyException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void delete(int id) {
        Matches matchs = new Matches();
        Match ret = new Match();
        FileInputStream fis = null;
        File file = new File("matches.xml");
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Matches.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            matchs = (Matches) unmarshaller.unmarshal(new File("matches.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(MatchDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator it = matchs.getMatches().iterator();
        while (it.hasNext()) {
            Match match = (Match) it.next();
            if (match.getId() == id) {
                it.remove();
            }
        }

    }

    @Override
    public Match get(int id) {
        Matches matchs = new Matches();
        Match ret = new Match();
        FileInputStream fis = null;
        File file = new File("matches.xml");
        try {
            fis = new FileInputStream(file);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatchDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(Matches.class
            );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            matchs = (Matches) unmarshaller.unmarshal(new File("matches.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(MatchDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        for (Match m : matchs.getMatches()) {
            if (m.getId() == id) {
                ret = m;
            }

        }
        return ret;
    }

    @Override
    public List<Match> getAll() {

        Matches matchs = new Matches();
        FileInputStream fis = null;
        File file = new File("matches.xml");
        try {
            fis = new FileInputStream(file);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MatchDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(Matches.class
            );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            matchs = (Matches) unmarshaller.unmarshal(new File("matches.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(MatchDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return matchs.getMatches();
    }

    private int getBiggestId(List<Match> l) {
        int max = 0;
        for (Match m : l) {
            if (m.getId() > max) {
                max = m.getId();
            }

        }
        return max;
    }

}
