package co.com.jdti.tech.vehicleapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jdti.tech.vehicleapi.model.entities.Procedure;

@Repository
public interface IProcedureRepository extends JpaRepository<Procedure, Long> {

}
