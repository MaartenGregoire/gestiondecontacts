package com.gestiondecontacts.mapper;

import com.gestiondecontacts.entity.EnterpriseEntity;
import com.gestiondecontacts.objects.Enterprise;
import com.gestiondecontacts.objects.EnterpriseInfo;
import org.springframework.stereotype.Component;

@Component
public class EnterpriseEntityMapper {
    
    private final AddressEntityMapper addressEntityMapper;
    
    public EnterpriseEntityMapper(AddressEntityMapper addressEntityMapper) {
        this.addressEntityMapper = addressEntityMapper;
    }
    
    public EnterpriseInfo mapToEnterpriseInfo(EnterpriseEntity enterpriseEntity) {
        return EnterpriseInfo.builder()
                .address(addressEntityMapper.map(enterpriseEntity.getAddress()))
                .vatNumber(enterpriseEntity.getVatNumber())
                .build();
    }
    
    public Enterprise mapToEnterprise(EnterpriseEntity enterpriseEntity) {
        return Enterprise.builder()
                .uuid(enterpriseEntity.getUuid())
                .enterpriseInfo(mapToEnterpriseInfo(enterpriseEntity))
                .build();
    }
    
    public EnterpriseEntity map(EnterpriseInfo enterpriseInfo, String uuid) {
        return EnterpriseEntity.builder()
                .uuid(uuid)
                .address(addressEntityMapper.map(enterpriseInfo.getAddress()))
                .vatNumber(enterpriseInfo.getVatNumber())
                .build();
    }
    
    public EnterpriseEntity map(Enterprise enterprise, Long id) {
        return EnterpriseEntity.builder()
                .id(id)
                .uuid(enterprise.getUuid())
                .address(addressEntityMapper.map(enterprise.getEnterpriseInfo().getAddress()))
                .vatNumber(enterprise.getEnterpriseInfo().getVatNumber())
                .build();
    }
}
