package com.gestiondecontacts.dto;

import com.gestiondecontacts.util.EqualsByStateObject;
import com.gestiondecontacts.util.NestedBuilder;

public class EnterpriseDto extends EqualsByStateObject {
    
    private String uuid;
    private EnterpriseInfoDto enterpriseInfo;
    
    public static Builder builder() {
        return new Builder();
    }
    
    private EnterpriseDto() {
    }
    
    public String getUuid() {
        return uuid;
    }
    
    public EnterpriseInfoDto getEnterpriseInfo() {
        return enterpriseInfo;
    }
    
    public static class Builder extends NestedBuilder<EnterpriseDto> {
        
        @Override
        protected EnterpriseDto createInstance() {
            return new EnterpriseDto();
        }
        
        private Builder() {
        }
        
        public Builder uuid(String uuid) {
            instance().uuid = uuid;
            return this;
        }
        
        public Builder enterpriseInfo(EnterpriseInfoDto enterpriseInfo) {
            instance().enterpriseInfo = enterpriseInfo;
            return this;
        }
    }
}