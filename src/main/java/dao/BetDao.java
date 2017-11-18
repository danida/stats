/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Model.Bet;
import Model.Bets;
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
public class BetDao {
    public void insert(Bet t) {
        Bets bets = new Bets();
        FileInputStream fis = null;
        File file = new File("bets.xml");
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            
            Logger.getLogger(BetDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Bets.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            bets = (Bets) unmarshaller.unmarshal(new File("bets.xml"));
            fis.close();
        } catch (JAXBException ex) {
            Logger.getLogger(BetDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(BetDao.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {

            JAXBContext context = JAXBContext.newInstance(Bets.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            List<Bet> l = bets.getBets();
            int id = getBiggestId(l);
            t.setId(id + 1);
            l.add(t);
            bets.setBets(l);
            m.marshal(bets, new File("bets.xml"));

        } catch (PropertyException ex) {
            Logger.getLogger(BetDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JAXBException ex) {
            Logger.getLogger(BetDao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    
    public void delete(int id) {
        Bets bets = new Bets();
        Bet ret = new Bet();
        FileInputStream fis = null;
        File file = new File("bets.xml");
        try {
            fis = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(BetDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(Bets.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            bets = (Bets) unmarshaller.unmarshal(new File("bets.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(BetDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        Iterator it = bets.getBets().iterator();
        while (it.hasNext()) {
            Bet match = (Bet) it.next();
            if (match.getId() == id) {
                it.remove();
            }
        }

    }

    public Bet get(int id) {
        Bets bets = new Bets();
        Bet ret = new Bet();
        FileInputStream fis = null;
        File file = new File("bets.xml");
        try {
            fis = new FileInputStream(file);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BetDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(Bets.class
            );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            bets = (Bets) unmarshaller.unmarshal(new File("bets.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(BetDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        for (Bet m : bets.getBets()) {
            if (m.getId() == id) {
                ret = m;
            }

        }
        return ret;
    }

    public List<Bet> getAll() {

        Bets bets = new Bets();
        FileInputStream fis = null;
        File file = new File("bets.xml");
        try {
            fis = new FileInputStream(file);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(BetDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        JAXBContext jaxbContext;

        try {
            jaxbContext = JAXBContext.newInstance(Bets.class
            );
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            bets = (Bets) unmarshaller.unmarshal(new File("bets.xml"));

        } catch (JAXBException ex) {
            Logger.getLogger(BetDao.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        return bets.getBets();
    }


    
    private int getBiggestId(List<Bet> l) {
        int max = 0;
        for (Bet m : l) {
            if (m.getId() > max) {
                max = m.getId();
            }

        }
        return max;
    }
}
