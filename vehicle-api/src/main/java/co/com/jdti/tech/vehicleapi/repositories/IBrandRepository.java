package co.com.jdti.tech.vehicleapi.repositories;

import co.com.jdti.tech.vehicleapi.model.entities.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Long> {

    List<Brand> findByOrderByDescriptionAsc();
}
