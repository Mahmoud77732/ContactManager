/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.springmvc.contactmanager.controller;

import com.springmvc.contactmanager.dao.ContactDAO;
import com.springmvc.contactmanager.model.Contact;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author d
 */
@Controller
@RequestMapping("/main-controller")
public class MainController {
    
    @Autowired
    private ContactDAO contactDAO; // call @Bean getContactDAO()
    
    /*
    @RequestMapping("/")
    public String home(){
        return "index";
    }
    */
        
    
    @RequestMapping("/")
    public ModelAndView listContacts(ModelAndView model){
        List<Contact> contacts = contactDAO.list();
        model.addObject("contacts", contacts);
        model.setViewName("index");
        return model;
    }
    
    @GetMapping("/new")
    public ModelAndView addContact(ModelAndView model){
        Contact newContact = new Contact();
        model.addObject("contact", newContact);
        model.setViewName("contact-form");
        return model;
    }
    
    @PostMapping("/save")
    public ModelAndView saveContact(@ModelAttribute Contact contact){
        if(contact.getId() == null){
            contactDAO.save(contact);
        }
        else{
            contactDAO.update(contact);
        }
        return new ModelAndView("redirect:/main-controller/");
    }
    
    @GetMapping("/edit")
    public ModelAndView editContact(HttpServletRequest request){
        Integer id = Integer.parseInt(request.getParameter("id"));
        Contact contact = contactDAO.get(id);
        ModelAndView model = new ModelAndView();
        model.addObject("contact", contact);
        model.setViewName("contact-form");
        return model;
    }
    
    @GetMapping("/delete")
    public ModelAndView deleteContact(@RequestParam Integer id){
        contactDAO.delete(id);
        return new ModelAndView("redirect:/main-controller/");
    }
    
}
