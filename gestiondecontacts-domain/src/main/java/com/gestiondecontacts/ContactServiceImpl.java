package com.gestiondecontacts;

import com.gestiondecontacts.entity.ContactEntity;
import com.gestiondecontacts.entity.EnterpriseEntity;
import com.gestiondecontacts.exception.EntityNotFoundException;
import com.gestiondecontacts.mapper.ContactEntityMapper;
import com.gestiondecontacts.objects.Contact;
import com.gestiondecontacts.objects.ContactInfo;
import com.gestiondecontacts.service.ContactService;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class ContactServiceImpl implements ContactService {
    
    private final ContactRepository contactRepository;
    private final ContactEntityMapper contactEntityMapper;
    private final EnterpriseRepository enterpriseRepository;
    
    public ContactServiceImpl(ContactRepository contactRepository,
            ContactEntityMapper contactEntityMapper, EnterpriseRepository enterpriseRepository) {
        this.contactRepository = contactRepository;
        this.contactEntityMapper = contactEntityMapper;
        this.enterpriseRepository = enterpriseRepository;
    }
    
    @Override
    public String createContact(ContactInfo contactInfo) {
        String uuid = UUID.randomUUID().toString();
        contactRepository.save(contactEntityMapper.map(contactInfo, uuid, findEnterprises(contactInfo.getEnterpriseUuids())));
        return uuid;
    }
    
    @Override
    public void updateContact(Contact contact) {
        ContactEntity contactEntity = contactRepository.findByUuid(contact.getUuid())
                .orElseThrow(() -> EntityNotFoundException.from("The contact you are trying to update does not exist"));
        contactRepository.save(contactEntityMapper.map(contact, contactEntity.getId(), findEnterprises(contact.getContactInfo().getEnterpriseUuids())));
    }
    
    @Override
    @Transactional
    public void deleteContact(String uuid) {
        contactRepository.deleteByUuid(uuid);
    }
    
    @Override
    public List<Contact> getcontacts() {
        return contactRepository.findAll().stream().map(contactEntityMapper::map).toList();
    }
    
    private List<EnterpriseEntity> findEnterprises(List<String> uuids) {
        return uuids.stream().map(u -> enterpriseRepository.findByUuid(u).orElseThrow(() -> EntityNotFoundException.from("Enterprise not found"))).toList();
    }
}
