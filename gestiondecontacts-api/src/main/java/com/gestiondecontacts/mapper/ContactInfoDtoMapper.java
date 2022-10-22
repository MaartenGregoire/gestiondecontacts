package com.gestiondecontacts.mapper;

import com.gestiondecontacts.dto.ContactInfoDto;
import com.gestiondecontacts.objects.ContactInfo;
import org.springframework.stereotype.Component;

@Component
public class ContactInfoDtoMapper {
    
    private final AddressDtoMapper addressDtoMapper;
    
    public ContactInfoDtoMapper(AddressDtoMapper addressDtoMapper) {
        this.addressDtoMapper = addressDtoMapper;
    }
    
    public ContactInfo map(ContactInfoDto contactInfoDto) {
        return ContactInfo.builder()
                .name(contactInfoDto.getName())
                .firstName(contactInfoDto.getFirstName())
                .address(addressDtoMapper.map(contactInfoDto.getAddress()))
                .statute(contactInfoDto.getStatute())
                .vatNumber(contactInfoDto.getVatNumber())
                .enterpriseUuids(contactInfoDto.getEnterpriseUuids())
                .build();
    }
    
    public ContactInfoDto map(ContactInfo contactInfo) {
        return ContactInfoDto.builder()
                .name(contactInfo.getName())
                .firstName(contactInfo.getFirstName())
                .address(addressDtoMapper.map(contactInfo.getAddress()))
                .statute(contactInfo.getStatute())
                .vatNumber(contactInfo.getVatNumber())
                .entrepriseUuids(contactInfo.getEnterpriseUuids())
                .build();
    }
}
