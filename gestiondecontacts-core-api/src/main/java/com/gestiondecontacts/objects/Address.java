package com.gestiondecontacts.objects;

import com.gestiondecontacts.util.NestedBuilder;

public class Address {
    
    private String street;
    private String number;
    private String boxNumber;
    private String postalCode;
    private String city;
    
    public static Builder builder() {
        return new Builder();
    }
    
    private Address() {
    }
    
    public String getStreet() {
        return street;
    }
    
    public String getNumber() {
        return number;
    }
    
    public String getBoxNumber() {
        return boxNumber;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public String getCity() {
        return city;
    }
    
    public static class Builder extends NestedBuilder<Address> {
        
        @Override
        protected Address createInstance() {
            return new Address();
        }
        
        private Builder() {
        }
        
        public Builder street(String street) {
            instance().street = street;
            return this;
        }
        
        public Builder number(String number) {
            instance().number = number;
            return this;
        }
        
        public Builder boxNumber(String boxNumber) {
            instance().boxNumber = boxNumber;
            return this;
        }
        
        public Builder postalCode(String postalCode) {
            instance().postalCode = postalCode;
            return this;
        }
        
        public Builder city(String city) {
            instance().city = city;
            return this;
        }
    }
}