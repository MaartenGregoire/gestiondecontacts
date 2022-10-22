package com.gestiondecontacts.dto;

import com.gestiondecontacts.util.EqualsByStateObject;
import com.gestiondecontacts.util.NestedBuilder;

public class EnterpriseInfoDto extends EqualsByStateObject {
    
    private AddressDto address;
    private String vatNumber;
    
    public static Builder builder() {
        return new Builder();
    }
    
    private EnterpriseInfoDto() {
    }
    
    public AddressDto getAddress() {
        return address;
    }
    
    public String getVatNumber() {
        return vatNumber;
    }
    
    public static class Builder extends NestedBuilder<EnterpriseInfoDto> {
        
        @Override
        protected EnterpriseInfoDto createInstance() {
            return new EnterpriseInfoDto();
        }
        
        private Builder() {
        }
        
        public Builder address(AddressDto address) {
            instance().address = address;
            return this;
        }
        
        public Builder vatNumber(String vatNumber) {
            instance().vatNumber = vatNumber;
            return this;
        }
    }
}
