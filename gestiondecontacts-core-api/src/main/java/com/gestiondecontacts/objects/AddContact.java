package com.gestiondecontacts.objects;

import com.gestiondecontacts.util.EqualsByStateObject;
import com.gestiondecontacts.util.NestedBuilder;

public class AddContact extends EqualsByStateObject {
    
    String contactUuid;
    String enterpriseUuid;
    
    public static Builder builder() {
        return new Builder();
    }
    
    private AddContact() {
    }
    
    public String getContactUuid() {
        return contactUuid;
    }
    
    public String getEnterpriseUuid() {
        return enterpriseUuid;
    }
    
    public static class Builder extends NestedBuilder<AddContact> {
        
        @Override
        protected AddContact createInstance() {
            return new AddContact();
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