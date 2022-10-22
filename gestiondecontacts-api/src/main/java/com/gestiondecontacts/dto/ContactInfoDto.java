package com.gestiondecontacts.dto;

import com.gestiondecontacts.objects.Statute;
import com.gestiondecontacts.util.EqualsByStateObject;
import com.gestiondecontacts.util.NestedBuilder;
import java.util.List;

public class ContactInfoDto extends EqualsByStateObject {
    
    private String name;
    private String firstName;
    private AddressDto address;
    private List<String> enterpriseUuids;
    private Statute statute;
    private String vatNumber;
    
    public static Builder builder() {
        return new Builder();
    }
    
    private ContactInfoDto() {
    }
    
    public String getName() {
        return name;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public AddressDto getAddress() {
        return address;
    }
    
    public List<String> getEnterpriseUuids() {
        return enterpriseUuids;
    }
    
    public Statute getStatute() {
        return statute;
    }
    
    public String getVatNumber() {
        return vatNumber;
    }
    
    public static class Builder extends NestedBuilder<ContactInfoDto> {
        
        @Override
        protected ContactInfoDto createInstance() {
            return new ContactInfoDto();
        }
        
        private Builder() {
        }
        
        public Builder name(String name) {
            instance().name = name;
            return this;
        }
        
        public Builder firstName(String firstName) {
            instance().firstName = firstName;
            return this;
        }
        
        public Builder address(AddressDto address) {
            instance().address = address;
            return this;
        }
        
        public Builder entrepriseUuids(List<String> enterpriseUuids) {
            instance().enterpriseUuids = enterpriseUuids;
            return this;
        }
        
        public Builder statute(Statute statute) {
            instance().statute = statute;
            return this;
        }
        
        public Builder vatNumber(String vatNumber) {
            instance().vatNumber = vatNumber;
            return this;
        }
    }
}
