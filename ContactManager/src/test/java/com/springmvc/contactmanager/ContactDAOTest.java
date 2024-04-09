/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.springmvc.contactmanager;

import com.springmvc.contactmanager.dao.ContactDAO;
import com.springmvc.contactmanager.dao.ContactDAOImpl;
import com.springmvc.contactmanager.model.Contact;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 *
 * @author mm887
 */
public class ContactDAOTest {
    
    private DriverManagerDataSource dataSource;
    private ContactDAO dao;
    
    public ContactDAOTest() {
    }
    
    //---------------------------------------------------------
    
    @BeforeEach
    public void setUpBeforeEach() {
        dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/contactdb");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        dao = new ContactDAOImpl(dataSource);
    }

    @Test
    void testSave(){
        Contact contact = new Contact("Mahmoud", "mahmoud@gmail.com", "egypt, Giza", "0100177");
        int result = dao.save(contact);
        assertTrue(result > 0);
    }
    
    @Test
    void testUpdate(){
        Contact contact = new Contact(3, "Mohamed", "m1@gmail.com", "egypt, giza", "010011");
        int result = dao.update(contact);
        assertTrue(result > 0);
    }
    
    @Test
    void testGet(){
        Integer id = 4;
        Contact contact = dao.get(id);
        if(contact != null){
            System.out.println(contact);
        }
        assertNotNull(contact);
    }
    
    @Test
    void testDelete(){
        Integer id = 1;
        int result = dao.delete(id);
        assertTrue(result > 0);
    }
    
    @Test
    void testList(){
        List<Contact> contacts = dao.list();
        if(!contacts.isEmpty()){
            contacts.forEach((item) -> {System.out.println(item);});
        }
        assertTrue( ! contacts.isEmpty() );
    }
    
    //---------------------------------------------------------    
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
