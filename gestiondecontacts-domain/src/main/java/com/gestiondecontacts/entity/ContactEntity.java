package com.gestiondecontacts.entity;

import com.gestiondecontacts.objects.Statute;
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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CONTACT")
public class ContactEntity extends EqualsByStateObject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CONTACTE_SEQ")
    @SequenceGenerator(name = "CONTACTS_SEQ", sequenceName = "CONTACTS_SEQ", allocationSize = 1)
    @Column(name = "ID")
    private Long id;
    @Column(name = "UUID", unique = true, nullable = false)
    private String uuid;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;
    @Embedded
    private AddressEntity address;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "CONTACT_ENTERPRISE",
            joinColumns = @JoinColumn(name = "CONTACT_ID", referencedColumnName = "ID"),
            inverseJoinColumns = @JoinColumn(name = "ENTERPRISE_ID", referencedColumnName = "ID"))
    private List<EnterpriseEntity> enterprises;
    
    @Column(name = "STATUTE")
    private Statute statute;
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
    
    public String getName() {
        return name;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public AddressEntity getAddress() {
        return address;
    }
    
    public List<EnterpriseEntity> getEnterprises() {
        return enterprises;
    }
    
    public Statute getStatute() {
        return statute;
    }
    
    public String getVatNumber() {
        return vatNumber;
    }
    
    public static class Builder extends NestedBuilder<ContactEntity> {
        
        @Override
        protected ContactEntity createInstance() {
            return new ContactEntity();
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
        
        public Builder name(String name) {
            instance().name = name;
            return this;
        }
        
        public Builder firstName(String firstName) {
            instance().firstName = firstName;
            return this;
        }
        
        public Builder address(AddressEntity address) {
            instance().address = address;
            return this;
        }
        
        public Builder enterprises(List<EnterpriseEntity> enterprises) {
            instance().enterprises = enterprises;
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
