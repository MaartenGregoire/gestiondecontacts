package com.gestiondecontacts.objects;

import com.gestiondecontacts.util.EqualsByStateObject;
import com.gestiondecontacts.util.NestedBuilder;
import java.util.List;

public class ContactInfo extends EqualsByStateObject {
    private String name;
    private String firstName;
    private Address address;
    private Statute statute;
    private String vatNumber;
    private List<String> enterpriseUuids;
    
    public static Builder builder() {
        return new Builder();
    }
    
    private ContactInfo() {
    }
    
    public String getName() {
        return name;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public Address getAddress() {
        return address;
    }
    
    public Statute getStatute() {
        return statute;
    }
    
    public String getVatNumber() {
        return vatNumber;
    }
    
    public List<String> getEnterpriseUuids() {
        return enterpriseUuids;
    }
    
    public static class Builder extends NestedBuilder<ContactInfo> {
        
        @Override
        protected ContactInfo createInstance() {
            return new ContactInfo();
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
        
        public Builder address(Address address) {
            instance().address = address;
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
        
        public Builder enterpriseUuids(List<String> enterpriseUuids) {
            instance().enterpriseUuids = enterpriseUuids;
            return this;
        }
        
    }
}
