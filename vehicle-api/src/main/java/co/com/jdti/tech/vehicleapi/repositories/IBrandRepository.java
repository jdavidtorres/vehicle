package co.com.jdti.tech.vehicleapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jdti.tech.vehicleapi.model.entities.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {

}
