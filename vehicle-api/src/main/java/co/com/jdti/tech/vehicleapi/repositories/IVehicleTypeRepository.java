package co.com.jdti.tech.vehicleapi.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.com.jdti.tech.vehicleapi.model.entities.VehicleType;

@Repository
public interface IVehicleTypeRepository extends CrudRepository<VehicleType, Long> {

}
