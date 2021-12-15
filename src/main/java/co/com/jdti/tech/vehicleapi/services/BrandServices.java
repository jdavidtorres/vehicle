package co.com.jdti.tech.vehicleapi.services;

import org.springframework.stereotype.Component;

import co.com.jdti.tech.vehicleapi.model.entities.Brand;
import co.com.jdti.tech.vehicleapi.repositories.IBrandRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class BrandServices {

    private final IBrandRepository iBrandRepository;

    public Brand save(Brand brand) {
        return iBrandRepository.save(brand);
    }
}
