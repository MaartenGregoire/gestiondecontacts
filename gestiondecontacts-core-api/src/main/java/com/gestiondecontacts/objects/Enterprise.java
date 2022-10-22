package com.gestiondecontacts.objects;

import com.gestiondecontacts.util.EqualsByStateObject;
import com.gestiondecontacts.util.NestedBuilder;

public class Enterprise extends EqualsByStateObject {
    
    private String uuid;
    private EnterpriseInfo enterpriseInfo;
    
    public static Builder builder() {
        return new Builder();
    }
    
    private Enterprise() {
    }
    
    public String getUuid() {
        return uuid;
    }
    
    public EnterpriseInfo getEnterpriseInfo() {
        return enterpriseInfo;
    }
    
    public static class Builder extends NestedBuilder<Enterprise> {
        
        @Override
        protected Enterprise createInstance() {
            return new Enterprise();
        }
        
        private Builder() {
        }
        
        public Builder uuid(String uuid) {
            instance().uuid = uuid;
            return this;
        }
        
        public Builder enterpriseInfo(EnterpriseInfo enterpriseInfo) {
            instance().enterpriseInfo = enterpriseInfo;
            return this;
        }
    }
}