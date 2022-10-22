package com.gestiondecontacts.service;

import com.gestiondecontacts.objects.AddContact;
import com.gestiondecontacts.objects.Enterprise;
import com.gestiondecontacts.objects.EnterpriseInfo;
import java.util.List;

public interface EnterpriseService {
    
    String createEnterprise(EnterpriseInfo enterpriseInfo);
    
    void deleteEnterprise(String uuid);
    
    void updateEnterprise(Enterprise enterprise);
    
    List<Enterprise> searchEnterpriseByVatNumber(String vatNumber);
    
    List<Enterprise> getEnterprises();
    
    void addContact(AddContact addContact);
}
