/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.contactmanager.dao;

import com.springmvc.contactmanager.model.Contact;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author mm887
 */
public class ContactDAOImpl implements ContactDAO {
    
    private JdbcTemplate jdbcTemplate;
    
    public ContactDAOImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int save(Contact contact) {
        return 0;
    }

    @Override
    public int update(Contact contact) {
        return 0;
    }

    @Override
    public Contact get(Integer id) {
        return null;
    }

    @Override
    public int delete(Integer id) {
        return 0;
    }

    @Override
    public List<Contact> list() {
        return null;
    }
    
}
