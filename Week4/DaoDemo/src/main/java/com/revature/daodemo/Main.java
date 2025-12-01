package com.revature.daodemo;

import com.revature.daodemo.dao.*;
import com.revature.daodemo.model.*;
import com.revature.daodemo.service.*;
import com.revature.daodemo.util.ConnectionUtil;
import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        ContactsService contactsService = new ContactsServiceImpl();
        Contacts contact = contactsService.getContact(2);
        System.out.println(contact);
    }
}