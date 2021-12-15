package co.com.jdti.tech.vehicleapi.controllers;

import co.com.jdti.tech.vehicleapi.model.entities.Brand;
import co.com.jdti.tech.vehicleapi.services.BrandServices;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin({"*"})
@RequestMapping("/brands")
@RequiredArgsConstructor
@SecurityScheme(type = SecuritySchemeType.HTTP, scheme = "Bearer", name = "Authorization", bearerFormat = "JWT")
@SecurityRequirement(name = "Authorization")
public class BrandController {

    private final BrandServices brandService;

    @PostMapping
    public ResponseEntity<Brand> saveBrand(@RequestBody Brand brand) {
        return ResponseEntity.ok(brandService.save(brand));
    }
}
