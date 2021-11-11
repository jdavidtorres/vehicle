package co.com.jdti.tech.vehicleapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jdti.tech.vehicleapi.model.entities.Brand;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin({ "*" })
@RequestMapping("/brands")
@RequiredArgsConstructor
public class BrandController {

    @GetMapping
    public ResponseEntity<Brand> getBrand() {
        return ResponseEntity.ok(new Brand());
    }
}
