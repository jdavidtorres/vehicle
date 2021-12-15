package co.com.jdti.tech.vehicleapi.repositories;

import co.com.jdti.tech.vehicleapi.model.entities.History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHistoryRepository extends JpaRepository<History, Long> {
}
