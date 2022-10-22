package com.gestiondecontacts.dto;

import com.gestiondecontacts.util.EqualsByStateObject;
import com.gestiondecontacts.util.NestedBuilder;

public class AddressDto extends EqualsByStateObject {
    
    private String street;
    private String number;
    private String boxnumber;
    private String postalCode;
    private String city;
    
    public static Builder builder() {
        return new Builder();
    }
    
    private AddressDto() {
    }
    
    public String getStreet() {
        return street;
    }
    
    public String getNumber() {
        return number;
    }
    
    public String getBoxnumber() {
        return boxnumber;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public String getCity() {
        return city;
    }
    
    public static class Builder extends NestedBuilder<AddressDto> {
        
        @Override
        protected AddressDto createInstance() {
            return new AddressDto();
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
            instance().boxnumber = boxNumber;
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
