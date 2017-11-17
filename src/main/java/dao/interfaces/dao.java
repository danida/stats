/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.interfaces;

import java.util.List;

/**
 *
 * @author dnovak
 */
public interface dao <T> {

    public void insert(T t);

    public void delete(T t);
    
    public T get(int id);
    
    public List<T> getAll();

}
