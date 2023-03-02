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
public interface IEvent<T> {
    void insertevent(T t);
    void deleteevent(T t);
    void updateevent(T t);
    List<T> readAll();
    T readById(int id);    
}