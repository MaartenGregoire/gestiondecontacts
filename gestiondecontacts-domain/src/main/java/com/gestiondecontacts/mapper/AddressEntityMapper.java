package com.gestiondecontacts.mapper;

import com.gestiondecontacts.entity.AddressEntity;
import com.gestiondecontacts.objects.Address;
import org.springframework.stereotype.Component;

@Component
public class AddressEntityMapper {
    
    public AddressEntity map(Address address) {
        return AddressEntity.builder()
                .street(address.getStreet())
                .number(address.getNumber())
                .boxNumber(address.getBoxNumber())
                .postalCode(address.getPostalCode())
                .city(address.getCity())
                .build();
    }
    
    public Address map(AddressEntity address) {
        return Address.builder()
                .street(address.getStreet())
                .number(address.getNumber())
                .boxNumber(address.getBoxNumber())
                .postalCode(address.getPostalCode())
                .city(address.getCity())
                .build();
    }
}
