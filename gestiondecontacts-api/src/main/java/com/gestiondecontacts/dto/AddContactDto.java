package com.gestiondecontacts.dto;

import com.gestiondecontacts.util.EqualsByStateObject;
import com.gestiondecontacts.util.NestedBuilder;

public class AddContactDto extends EqualsByStateObject {
    
    private String contactUuid;
    private String enterpriseUuid;
    
    public static Builder builder() {
        return new Builder();
    }
    
    private AddContactDto() {
    }
    
    public String getContactUuid() {
        return contactUuid;
    }
    
    public String getEnterpriseUuid() {
        return enterpriseUuid;
    }
    
    public static class Builder extends NestedBuilder<AddContactDto> {
        
        @Override
        protected AddContactDto createInstance() {
            return new AddContactDto();
        }
        
        private Builder() {
        }
        
        public Builder contactUuid(String contactUuid) {
            instance().contactUuid = contactUuid;
            return this;
        }
        
        public Builder enterpriseUuid(String enterpriseUuid) {
            instance().enterpriseUuid = enterpriseUuid;
            return this;
        }
    }
}