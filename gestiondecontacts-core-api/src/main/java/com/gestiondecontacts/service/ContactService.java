package com.gestiondecontacts.service;

import com.gestiondecontacts.objects.Contact;
import com.gestiondecontacts.objects.ContactInfo;
import java.util.List;

public interface ContactService {
    
    String createContact(ContactInfo contactInfo);
    
    void updateContact(Contact contact);
    
    void deleteContact(String uuid);
    
    List<Contact> getcontacts();
}
