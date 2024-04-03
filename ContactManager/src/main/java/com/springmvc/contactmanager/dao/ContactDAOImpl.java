/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.contactmanager.dao;

import com.springmvc.contactmanager.model.Contact;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

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
        String sql = "INSERT INTO Contact(name, email, address, phone) VALUES (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone());
    }

    @Override
    public int update(Contact contact) {
        String sql = "UPDATE Contact SET name=?, email=?, address=?, phone=? WHERE contact_id=?";
        return jdbcTemplate.update(sql, contact.getName(), contact.getEmail(), contact.getAddress(), contact.getPhone(), contact.getId());
    }

    @Override
    public Contact get(Integer id) {
        String sql = "SELECT * FROM Contact WHERE contact_id=" + id;
        
        ResultSetExtractor<Contact> extractor = new ResultSetExtractor<Contact>(){
                @Override
                public Contact extractData(ResultSet result) throws SQLException, DataAccessException{
                    if(result.next()){
                        String name = result.getString("name");
                        String email = result.getString("email");
                        String address = result.getString("address");
                        String phone = result.getString("phone");
                        return new Contact(id, name, email, address, phone);
                    }
                    return null;
                }
        };
        
        return jdbcTemplate.query(sql, extractor);
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM Contact WHERE contact_id=" + id;
        return jdbcTemplate.update(sql);
    }

    @Override
    public List<Contact> list() {
        String sql = "SELECT * FROM Contact";
        RowMapper<Contact> rowmapper = new RowMapper<Contact>(){
            @Override
            public Contact mapRow(ResultSet result, int rowNum) throws SQLException{
                Integer id = result.getInt("contact_id");
                String name = result.getString("name");
                String email = result.getString("email");
                String address = result.getString("address");
                String phone = result.getString("phone");
                return new Contact(id, name, email, address, phone);
            }
        };
        return jdbcTemplate.query(sql, rowmapper);
    }
    
}
