package com.gestiondecontacts.mapper;

import com.gestiondecontacts.dto.AddressDto;
import com.gestiondecontacts.objects.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressDtoMapper {
    
    public Address map(AddressDto addressDto) {
        return Address.builder()
                .street(addressDto.getStreet())
                .number(addressDto.getNumber())
                .boxNumber(addressDto.getBoxnumber())
                .postalCode(addressDto.getPostalCode())
                .city(addressDto.getCity())
                .build();
    }
    
    public AddressDto map(Address address) {
        return AddressDto.builder()
                .street(address.getStreet())
                .number(address.getNumber())
                .boxNumber(address.getBoxNumber())
                .postalCode(address.getPostalCode())
                .city(address.getCity())
                .build();
    }
}
