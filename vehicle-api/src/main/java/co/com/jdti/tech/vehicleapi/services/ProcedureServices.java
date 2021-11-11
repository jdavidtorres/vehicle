package co.com.jdti.tech.vehicleapi.services;

import java.util.List;

import org.springframework.stereotype.Component;

import co.com.jdti.tech.vehicleapi.model.entities.Procedure;
import co.com.jdti.tech.vehicleapi.repositories.IProcedureRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class ProcedureServices {

    private final IProcedureRepository iProcedureRepository;

    public Procedure save(Procedure procedure) {
        return iProcedureRepository.save(procedure);
    }

    public Procedure findById(Long id) {
        return iProcedureRepository.findById(id).orElse(null);
    }

    public List<Procedure> findAll() {
        return iProcedureRepository.findAll();
    }

    public void delete(Long id) {
        iProcedureRepository.deleteById(id);
    }
}
