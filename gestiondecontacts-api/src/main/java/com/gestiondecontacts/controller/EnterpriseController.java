package com.gestiondecontacts.controller;

import com.gestiondecontacts.dto.AddContactDto;
import com.gestiondecontacts.dto.ContactInfoDto;
import com.gestiondecontacts.dto.EnterpriseDto;
import com.gestiondecontacts.dto.EnterpriseInfoDto;
import com.gestiondecontacts.mapper.EnterpriseDtoMapper;
import com.gestiondecontacts.mapper.EnterpriseInfoDtoMapper;
import com.gestiondecontacts.objects.AddContact;
import com.gestiondecontacts.service.EnterpriseService;
import com.gestiondecontacts.util.Validator;
import java.util.List;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enterprises")
public class EnterpriseController {
   
    private final EnterpriseService enterpriseService;
    private final EnterpriseDtoMapper enterpriseDtoMapper;
    private final EnterpriseInfoDtoMapper enterpriseInfoDtoMapper;
    
    public EnterpriseController(EnterpriseService enterpriseService, EnterpriseDtoMapper enterpriseDtoMapper, EnterpriseInfoDtoMapper enterpriseInfoDtoMapper) {
        this.enterpriseService = enterpriseService;
        this.enterpriseDtoMapper = enterpriseDtoMapper;
        this.enterpriseInfoDtoMapper = enterpriseInfoDtoMapper;
    }
    
    @PostMapping("/create")
    public String createEnterprise(@RequestBody EnterpriseInfoDto enterpriseInfoDto) {
        return enterpriseService.createEnterprise(enterpriseInfoDtoMapper.map(enterpriseInfoDto));
    }
    
    @PutMapping("/update")
    public void updateEnterprise(@RequestBody EnterpriseDto enterpriseDto) {
        enterpriseService.updateEnterprise(enterpriseDtoMapper.map(enterpriseDto));
    }
    
    @DeleteMapping("/delete")
    public void deleteEnterprise(@RequestParam String uuid) {
        enterpriseService.deleteEnterprise(uuid);
    }
    
    @GetMapping("/search")
    public List<EnterpriseDto> searchEnterprise(@RequestParam String vatNumber) {
        return enterpriseService.searchEnterpriseByVatNumber(vatNumber)
                .stream().map(enterpriseDtoMapper::map).toList();
    }
    
    @GetMapping("/")
    public List<EnterpriseDto> getEnterprises() {
        return enterpriseService.getEnterprises().stream().map(enterpriseDtoMapper::map).toList();
    }
    
    @PostMapping("/addcontact")
    public void addContact(@RequestBody AddContactDto addContactDto) {
        Validator.validate(addContactDto.getContactUuid(), "contactUuid");
        Validator.validate(addContactDto.getEnterpriseUuid(), "enterpriseUuid");
        
        enterpriseService.addContact(AddContact.builder()
                .contactUuid(addContactDto.getContactUuid())
                .enterpriseUuid(addContactDto.getEnterpriseUuid())
                .build());
    }
    
}
