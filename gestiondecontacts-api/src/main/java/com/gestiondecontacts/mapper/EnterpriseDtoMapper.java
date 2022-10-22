package com.gestiondecontacts.mapper;

import com.gestiondecontacts.dto.EnterpriseDto;
import com.gestiondecontacts.objects.Enterprise;
import org.springframework.stereotype.Component;

@Component
public class EnterpriseDtoMapper {
    
    private final EnterpriseInfoDtoMapper enterpriseInfoDtoMapper;
    
    public EnterpriseDtoMapper(EnterpriseInfoDtoMapper enterpriseInfoDtoMapper) {
        this.enterpriseInfoDtoMapper = enterpriseInfoDtoMapper;
    }
    
    public Enterprise map(EnterpriseDto enterpriseDto) {
        return Enterprise.builder()
                .uuid(enterpriseDto.getUuid())
                .enterpriseInfo(enterpriseInfoDtoMapper.map(enterpriseDto.getEnterpriseInfo()))
                .build();
    }
    
    public EnterpriseDto map(Enterprise enterprise) {
        return EnterpriseDto.builder()
                .uuid(enterprise.getUuid())
                .enterpriseInfo(enterpriseInfoDtoMapper.map(enterprise.getEnterpriseInfo()))
                .build();
    }
}
