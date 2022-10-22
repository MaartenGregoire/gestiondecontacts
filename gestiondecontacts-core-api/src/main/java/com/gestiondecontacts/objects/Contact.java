package com.gestiondecontacts.objects;

import com.gestiondecontacts.util.NestedBuilder;
import java.util.List;

public class Contact {
    
    private String uuid;
    private ContactInfo contactInfo;
    
    public static Builder builder() {
        return new Builder();
    }
    
    private Contact() {
    }
    
    public String getUuid() {
        return uuid;
    }
    
    public ContactInfo getContactInfo() {
        return contactInfo;
    }
    
    public static class Builder extends NestedBuilder<Contact> {
        
        @Override
        protected Contact createInstance() {
            return new Contact();
        }
        
        private Builder() {
        }
        
        public Builder uuid(String uuid) {
            instance().uuid = uuid;
            return this;
        }
        
        public Builder contactInfo(ContactInfo contactInfo) {
            instance().contactInfo = contactInfo;
            return this;
        }
        
    }
}
