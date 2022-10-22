package com.gestiondecontacts.mapper;

import com.gestiondecontacts.dto.EnterpriseInfoDto;
import com.gestiondecontacts.objects.EnterpriseInfo;
import org.springframework.stereotype.Component;

@Component
public class EnterpriseInfoDtoMapper {
    
    private final AddressDtoMapper addressDtoMapper;
    
    public EnterpriseInfoDtoMapper(AddressDtoMapper addressDtoMapper) {
        this.addressDtoMapper = addressDtoMapper;
    }
    
    public EnterpriseInfo map(EnterpriseInfoDto enterpriseInfoDto) {
        return EnterpriseInfo.builder()
                .address(this.addressDtoMapper.map(enterpriseInfoDto.getAddress()))
                .vatNumber(enterpriseInfoDto.getVatNumber())
                .build();
    }
    
    public EnterpriseInfoDto map(EnterpriseInfo enterpriseInfo) {
        return EnterpriseInfoDto.builder()
                .address(addressDtoMapper.map(enterpriseInfo.getAddress()))
                .vatNumber(enterpriseInfo.getVatNumber())
                .build();
    }
}
