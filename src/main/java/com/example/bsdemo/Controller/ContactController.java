package com.example.bsdemo.Controller;


import com.example.bsdemo.Pojo.Contacts;
import com.example.bsdemo.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class ContactController {

    @Autowired
    private ContactService contactService;

    // 创建新的联系人
    @PostMapping
    public ResponseEntity<Contacts> addContact(@RequestBody Contacts contact) {
        boolean isAdded = contactService.addContact(contact);
        if (isAdded) {
            return new ResponseEntity<>(contact, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 获取所有联系人
    @GetMapping
    public ResponseEntity<List<Contacts>> getAllContacts() {
        List<Contacts> contacts = contactService.getAllContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    // 根据id获取联系人
    @GetMapping("/{id}")
    public ResponseEntity<Contacts> getContactById(@PathVariable Long id) {
        Contacts contact = contactService.queryContact(id);
        if (contact != null) {
            return new ResponseEntity<>(contact, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 更新联系人信息
    @PutMapping("/{id}")
    public ResponseEntity<Contacts> updateContact(@PathVariable Long id, @RequestBody Contacts contactDetails) {
        Contacts contact = contactService.queryContact(id);
        if (contact != null) {
            contact.setName(contactDetails.getName());
            contact.setAddress(contactDetails.getAddress());
            contact.setTel(contactDetails.getTel());
            boolean isUpdated = contactService.updateContact(contact);
            if (isUpdated) {
                return new ResponseEntity<>(contact, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // 删除联系人
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        boolean isDeleted = contactService.deleteContact(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

