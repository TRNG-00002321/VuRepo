package com.revature.daodemo.service;

import com.revature.daodemo.dao.ContactDAO;
import com.revature.daodemo.dao.ContactsJDBCImpl;
import com.revature.daodemo.model.Contacts;

import java.util.List;

public class ContactsServiceImpl implements ContactsService{
    public  Contacts getContact(int id) {

        ContactDAO contactDAO=new ContactsJDBCImpl();
        if(id>0) {
            Contacts contacts = contactDAO.getContact(id);
            return contacts;
        }
        return null;
    }

    @Override
    public List<Contacts> getAllContacts() {
        return List.of();
    }

    @Override
    public void save(Contacts contacts) {

    }

    @Override
    public Contacts update(Contacts contacts) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}