package com.gestiondecontacts;

import com.gestiondecontacts.entity.EnterpriseEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<EnterpriseEntity, Long> {
    Optional<EnterpriseEntity> findByUuid(String uuid);
    
    void deleteByUuid(String uuid);
    
    List<EnterpriseEntity> findByVatNumber(String vatNumber);
}
