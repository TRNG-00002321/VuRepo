package com.revature.daodemo.dao;

import com.revature.daodemo.model.Contacts;

import java.util.List;

public interface ContactDAO {

    List<Contacts> getAllContacts();

    Contacts getContact(int id);

    void save(Contacts contacts);

    Contacts update(Contacts contacts);

    void delete(int id);
}