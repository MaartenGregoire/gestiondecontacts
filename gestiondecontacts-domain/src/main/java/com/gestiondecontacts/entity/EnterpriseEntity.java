package com.gestiondecontacts.entity;

import com.gestiondecontacts.util.EqualsByStateObject;
import com.gestiondecontacts.util.NestedBuilder;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ENTERPRISE")
public class EnterpriseEntity extends EqualsByStateObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACTE_SEQ")
    @SequenceGenerator(name = "CONTACTS_SEQ", sequenceName = "CONTACTS_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    
    @Column(name = "UUID", nullable = false, unique = true)
    private String uuid;
    
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "street", column = @Column(name = "STREET")),
            @AttributeOverride(name = "number", column = @Column(name = "NUMBER")),
            @AttributeOverride(name = "boxNumber", column = @Column(name = "BOX_NUMBER")),
            @AttributeOverride(name = "postalCode", column = @Column(name = "POSTAL_CODE")),
            @AttributeOverride(name = "city", column = @Column(name = "CITY"))
    })
    private AddressEntity address;
    
    @Column(name = "VAT_NUMBER")
    private String vatNumber;
    
    public static Builder builder() {
        return new Builder();
    }
    
    public Long getId() {
        return id;
    }
    
    public String getUuid() {
        return uuid;
    }
    
    public AddressEntity getAddress() {
        return address;
    }
    
    public String getVatNumber() {
        return vatNumber;
    }
    
    public static class Builder extends NestedBuilder<EnterpriseEntity> {
        
        @Override
        protected EnterpriseEntity createInstance() {
            return new EnterpriseEntity();
        }
        
        private Builder() {
        }
        
        public Builder id(Long id) {
            instance().id = id;
            return this;
        }
        
        public Builder uuid(String uuid) {
            instance().uuid = uuid;
            return this;
        }
        
        public Builder address(AddressEntity address) {
            instance().address = address;
            return this;
        }
        
        public Builder vatNumber(String vatNumber) {
            instance().vatNumber = vatNumber;
            return this;
        }
    }
}
