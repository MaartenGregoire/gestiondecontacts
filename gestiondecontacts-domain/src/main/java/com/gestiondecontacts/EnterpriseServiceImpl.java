package com.gestiondecontacts;

import com.gestiondecontacts.entity.ContactEntity;
import com.gestiondecontacts.entity.EnterpriseEntity;
import com.gestiondecontacts.exception.EntityNotFoundException;
import com.gestiondecontacts.mapper.EnterpriseEntityMapper;
import com.gestiondecontacts.objects.AddContact;
import com.gestiondecontacts.objects.Enterprise;
import com.gestiondecontacts.objects.EnterpriseInfo;
import com.gestiondecontacts.service.EnterpriseService;
import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class EnterpriseServiceImpl implements EnterpriseService {
    
    private final EnterpriseRepository enterpriseRepository;
    private final EnterpriseEntityMapper enterpriseEntityMapper;
    private final ContactRepository contactRepository;
    
    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository,
            EnterpriseEntityMapper enterpriseEntityMapper, ContactRepository contactRepository) {
        this.enterpriseRepository = enterpriseRepository;
        this.enterpriseEntityMapper = enterpriseEntityMapper;
        this.contactRepository = contactRepository;
    }
    
    @Override
    public String createEnterprise(EnterpriseInfo enterpriseInfo) {
        String uuid = UUID.randomUUID().toString();
        enterpriseRepository.save(enterpriseEntityMapper.map(enterpriseInfo, uuid));
        return uuid;
    }
    
    @Override
    @Transactional
    public void deleteEnterprise(String uuid) {
        enterpriseRepository.deleteByUuid(uuid);
    }
    
    @Override
    public void updateEnterprise(Enterprise enterprise) {
        EnterpriseEntity enterpriseEntity =
                enterpriseRepository.findByUuid(enterprise.getUuid()).orElseThrow(() -> EntityNotFoundException.from("The enterprise you are trying to update does not exist"));
        enterpriseRepository.save(enterpriseEntityMapper.map(enterprise, enterpriseEntity.getId()));
    }
    
    @Override
    public List<Enterprise> searchEnterpriseByVatNumber(String vatNumber) {
        return enterpriseRepository.findByVatNumber(vatNumber).stream()
                .map(enterpriseEntityMapper::mapToEnterprise).toList();
    }
    
    @Override
    public List<Enterprise> getEnterprises() {
        return enterpriseRepository.findAll().stream().map(enterpriseEntityMapper::mapToEnterprise).toList();
    }
    
    @Override
    public void addContact(AddContact addContact) {
        ContactEntity contactEntity = contactRepository.findByUuid(addContact.getContactUuid())
                .orElseThrow(() -> EntityNotFoundException.from("The contact you are trying to add to an enterprise does not exist"));
        EnterpriseEntity enterpriseEntity = enterpriseRepository.findByUuid(addContact.getEnterpriseUuid())
                .orElseThrow(() -> EntityNotFoundException.from("The enterprise you are trying to add a contact to does not exist"));
        List<EnterpriseEntity> enterpriseEntities = contactEntity.getEnterprises();
        enterpriseEntities.add(enterpriseEntity);
        contactRepository.save(ContactEntity.builder()
                        .id(contactEntity.getId())
                        .uuid(contactEntity.getUuid())
                        .enterprises(enterpriseEntities)
                        .address(contactEntity.getAddress())
                        .name(contactEntity.getName())
                        .firstName(contactEntity.getFirstName())
                .build());
    }
}
