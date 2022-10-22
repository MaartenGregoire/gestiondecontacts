package com.gestiondecontacts.objects;

import com.gestiondecontacts.util.NestedBuilder;

public class EnterpriseInfo {
    
    private Address address;
    private String vatNumber;
    
    public static Builder builder() {
        return new Builder();
    }
    
    private EnterpriseInfo() {
    }
    
    public Address getAddress() {
        return address;
    }
    
    public String getVatNumber() {
        return vatNumber;
    }
    
    public static class Builder extends NestedBuilder<EnterpriseInfo> {
        
        @Override
        protected EnterpriseInfo createInstance() {
            return new EnterpriseInfo();
        }
        
        private Builder() {
        }
        
        public Builder address(Address address) {
            instance().address = address;
            return this;
        }
        
        public Builder vatNumber(String vatNumber) {
            instance().vatNumber = vatNumber;
            return this;
        }
    }
}
