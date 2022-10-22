package com.gestiondecontacts.entity;

import com.gestiondecontacts.util.EqualsByStateObject;
import com.gestiondecontacts.util.NestedBuilder;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class AddressEntity extends EqualsByStateObject {
    
    @Column
    private String street;
    @Column
    private String number;
    @Column
    private String boxNumber;
    @Column
    private String postalCode;
    @Column
    private String city;
    
    public static Builder builder() {
        return new Builder();
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
    
    public static class Builder extends NestedBuilder<AddressEntity> {
    
        @Override
        protected AddressEntity createInstance() {
            return new AddressEntity();
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
