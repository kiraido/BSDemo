package com.example.bsdemo.Service;


import com.example.bsdemo.Pojo.Contacts;

import java.util.List;


public interface ContactService {
    boolean addContact(Contacts contact);

    boolean deleteContact(Long id);

    Contacts queryContact(Long id);

    boolean updateContact(Contacts contact);

    List<Contacts> getAllContacts();
}
