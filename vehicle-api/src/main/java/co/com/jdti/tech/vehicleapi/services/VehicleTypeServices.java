package co.com.jdti.tech.vehicleapi.services;

import org.springframework.stereotype.Component;

import co.com.jdti.tech.vehicleapi.repositories.IVehicleTypeRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class VehicleTypeServices {
    
    private final IVehicleTypeRepository vehicleTypeRepository;
}
