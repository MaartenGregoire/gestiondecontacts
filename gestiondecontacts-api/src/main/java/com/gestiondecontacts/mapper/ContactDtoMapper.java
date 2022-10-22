package com.gestiondecontacts.mapper;

import com.gestiondecontacts.dto.ContactDto;
import com.gestiondecontacts.objects.Contact;
import org.springframework.stereotype.Component;

@Component
public class ContactDtoMapper {
    
    private final ContactInfoDtoMapper contactInfoDtoMapper;
    
    public ContactDtoMapper(ContactInfoDtoMapper contactInfoDtoMapper) {
        this.contactInfoDtoMapper = contactInfoDtoMapper;
    }
    
    public Contact map(ContactDto contactDto) {
        return Contact.builder()
                .uuid(contactDto.getUuid())
                .contactInfo(contactInfoDtoMapper.map(contactDto.getContactInfo()))
                .build();
    }
    
    public ContactDto map(Contact contact) {
        return ContactDto.builder()
                .uuid(contact.getUuid())
                .contactInfoDto(contactInfoDtoMapper.map(contact.getContactInfo()))
                .build();
    }
}
