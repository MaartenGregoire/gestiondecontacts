package com.gestiondecontacts.mapper;

import com.gestiondecontacts.entity.ContactEntity;
import com.gestiondecontacts.entity.EnterpriseEntity;
import com.gestiondecontacts.objects.Contact;
import com.gestiondecontacts.objects.ContactInfo;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ContactEntityMapper {
    
    private final AddressEntityMapper addressEntityMapper;
    
    public ContactEntityMapper(AddressEntityMapper addressEntityMapper) {
        this.addressEntityMapper = addressEntityMapper;
    }
    
    public ContactEntity map(ContactInfo contactInfo, String uuid, List<EnterpriseEntity> enterpriseEntities) {
        return ContactEntity.builder()
                .uuid(uuid)
                .firstName(contactInfo.getFirstName())
                .name(contactInfo.getName())
                .address(addressEntityMapper.map(contactInfo.getAddress()))
                .statute(contactInfo.getStatute())
                .enterprises(enterpriseEntities)
                .vatNumber(contactInfo.getVatNumber())
                .build();
    }
    
    public Contact map(ContactEntity contactEntity) {
        return Contact.builder()
                .uuid(contactEntity.getUuid())
                .contactInfo(
                        ContactInfo.builder()
                                .firstName(contactEntity.getFirstName())
                                .name(contactEntity.getName())
                                .address(addressEntityMapper.map(contactEntity.getAddress()))
                                .statute(contactEntity.getStatute())
                                .enterpriseUuids(contactEntity.getEnterprises().stream()
                                        .map(EnterpriseEntity::getUuid).toList())
                                .vatNumber(contactEntity.getVatNumber()).build())
                .build();
    }
    
    public ContactEntity map(Contact contact, Long id, List<EnterpriseEntity> enterpriseEntities) {
        return ContactEntity.builder()
                .id(id)
                .uuid(contact.getUuid())
                .firstName(contact.getContactInfo().getFirstName())
                .name(contact.getContactInfo().getName())
                .address(addressEntityMapper.map(contact.getContactInfo().getAddress()))
                .statute(contact.getContactInfo().getStatute())
                .enterprises(enterpriseEntities)
                .vatNumber(contact.getContactInfo().getVatNumber())
                .build();
    }
}
