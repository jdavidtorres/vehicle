package co.com.jdti.tech.vehicleapi.services;

import java.util.List;

import org.springframework.stereotype.Component;

import co.com.jdti.tech.vehicleapi.model.entities.VehicleType;
import co.com.jdti.tech.vehicleapi.repositories.IVehicleTypeRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VehicleTypeServices {

    private final IVehicleTypeRepository vehicleTypeRepository;

    public VehicleType save(VehicleType vehicleType) {
        return vehicleTypeRepository.save(vehicleType);
    }

    public VehicleType findById(Long id) {
        return vehicleTypeRepository.findById(id).orElse(null);
    }

    public void deleteVehicleType(Long id) {
        vehicleTypeRepository.deleteById(id);
    }

    public List<VehicleType> findAll() {
        return vehicleTypeRepository.findAll();
    }
}
