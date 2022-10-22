package com.gestiondecontacts.dto;

import com.gestiondecontacts.util.EqualsByStateObject;
import com.gestiondecontacts.util.NestedBuilder;

public class ContactDto extends EqualsByStateObject {
    
    private String uuid;
    private ContactInfoDto contactInfo;
    
    public static Builder builder() {
        return new Builder();
    }
    
    private ContactDto() {
    }
    
    public String getUuid() {
        return uuid;
    }
    
    public ContactInfoDto getContactInfo() {
        return contactInfo;
    }
    
    public static class Builder extends NestedBuilder<ContactDto> {
        
        @Override
        protected ContactDto createInstance() {
            return new ContactDto();
        }
        
        private Builder() {
        }
        
        public Builder uuid(String uuid) {
            instance().uuid = uuid;
            return this;
        }
        
        public Builder contactInfoDto(ContactInfoDto contactInfoDto) {
            instance().contactInfo = contactInfoDto;
            return this;
        }
        
    }
}
