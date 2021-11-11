package co.com.jdti.tech.vehicleapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jdti.tech.vehicleapi.model.entities.Brand;
import co.com.jdti.tech.vehicleapi.services.BrandServices;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin({ "*" })
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {

    private final BrandServices brandService;

    @PostMapping
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand) {
        return ResponseEntity.ok(brandService.save(brand));
    }
}
