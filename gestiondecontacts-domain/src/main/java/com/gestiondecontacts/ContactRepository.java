package com.gestiondecontacts;

import com.gestiondecontacts.entity.ContactEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<ContactEntity, Long> {
    
    Optional<ContactEntity> findByUuid(String uuid);
    
    void deleteByUuid(String uuid);
}
