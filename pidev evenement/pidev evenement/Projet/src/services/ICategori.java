/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;

/**
 *
 * @author wiemhjiri
 * @param <T>
 */
public interface ICategori<T> {
    void insertcategori(T t);
    void deletecategori(T t);
    void updatecategori(T t);
    List<T> readAll();
    T readById(int id);    
}
