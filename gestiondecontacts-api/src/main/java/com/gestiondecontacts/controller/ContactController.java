package com.gestiondecontacts.controller;

import com.gestiondecontacts.dto.ContactDto;
import com.gestiondecontacts.dto.ContactInfoDto;
import com.gestiondecontacts.exception.ValidationFailedException;
import com.gestiondecontacts.mapper.ContactDtoMapper;
import com.gestiondecontacts.mapper.ContactInfoDtoMapper;
import com.gestiondecontacts.service.ContactService;
import com.gestiondecontacts.util.Validator;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/contacts")
public class ContactController {
    
    private final ContactService contactService;
    
    private final ContactInfoDtoMapper contactInfoDtoMapper;
    
    private final ContactDtoMapper contactDtoMapper;
    
    public ContactController(ContactService contactService,
            ContactInfoDtoMapper contactInfoDtoMapper, ContactDtoMapper contactDtoMapper) {
        this.contactService = contactService;
        this.contactInfoDtoMapper = contactInfoDtoMapper;
        this.contactDtoMapper = contactDtoMapper;
    }
    
    @PostMapping("/create")
    public String createContact(@RequestBody ContactInfoDto contactInfoDto) {
        validate(contactInfoDto);
        return contactService.createContact(contactInfoDtoMapper.map(contactInfoDto));
    }
    
    @PutMapping("/update")
    public void updateContact(@RequestBody ContactDto contactDto) {
        validate(contactDto.getContactInfo());
        contactService.updateContact(contactDtoMapper.map(contactDto));
    }
    
    @DeleteMapping("/delete")
    public void deleteContact(@RequestParam String uuid) {
        contactService.deleteContact(uuid);
    }
    
    @GetMapping("/")
    public List<ContactDto> getContacts() {
        return contactService.getcontacts()
                .stream()
                .map(contactDtoMapper::map)
                .toList();
    }
    
    private void validate(ContactInfoDto contactInfoDto) {
        Validator.validate(contactInfoDto.getAddress(), "address");
        Validator.validate(contactInfoDto.getName(), "name");
        Validator.validate(contactInfoDto.getFirstName(), "firstName");
        Validator.validate(contactInfoDto.getEnterpriseUuids(), "enterpriseUuids");
        Validator.validate(contactInfoDto.getStatute(), "statute");
        if (contactInfoDto.getEnterpriseUuids().isEmpty()) {
            throw ValidationFailedException.from("A contact should have at least one enterprise");
        }
        if (contactInfoDto.getStatute().isVatNumberObligated()) {
            Validator.validate(contactInfoDto.getVatNumber(), "vatNumber");
        }
    }
    
}
