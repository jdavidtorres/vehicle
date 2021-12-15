package co.com.jdti.tech.vehicleapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.com.jdti.tech.vehicleapi.model.entities.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {

    Role findByRoleName(String roleName);
}
