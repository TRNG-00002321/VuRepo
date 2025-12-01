// validation logic goes here to validate inputs
// login could be use here

package com.revature.daodemo.service;
import com.revature.daodemo.model.*;

import java.util.List;

public interface ContactsService {

    List<Contacts> getAllContacts();

    Contacts getContact(int id);

    void save(Contacts contacts);

    Contacts update(Contacts contacts);

    void delete(int id);
}
