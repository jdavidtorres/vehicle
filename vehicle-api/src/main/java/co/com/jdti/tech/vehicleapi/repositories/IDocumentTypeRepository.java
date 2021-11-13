package co.com.jdti.tech.vehicleapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jdti.tech.vehicleapi.model.entities.DocumentType;

@Repository
public interface IDocumentTypeRepository extends JpaRepository<DocumentType, Long> {

}
