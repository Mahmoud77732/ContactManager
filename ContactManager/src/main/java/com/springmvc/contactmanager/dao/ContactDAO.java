/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.springmvc.contactmanager.dao;

import com.springmvc.contactmanager.model.Contact;
import java.util.List;

/**
 *
 * @author mm887
 */
public interface ContactDAO {
    
    public int save(Contact contact);
    
    public int update(Contact contact);
    
    public Contact get(Integer id);
    
    public int delete(Integer id);
    
    public List<Contact> list();
    
}
