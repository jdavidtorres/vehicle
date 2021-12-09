package co.com.jdti.tech.vehicleapi.repositories;

import co.com.jdti.tech.vehicleapi.model.entities.VehiclePhoto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVehiclePhoto extends JpaRepository<VehiclePhoto, Long> {
}
