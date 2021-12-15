package co.com.jdti.tech.vehicleapi.controllers;

import co.com.jdti.tech.vehicleapi.model.entities.UserEntity;
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
@RequestMapping("/users")
@RequiredArgsConstructor
@SecurityScheme(type = SecuritySchemeType.HTTP, scheme = "Bearer", name = "Authorization", bearerFormat = "JWT")
@SecurityRequirement(name = "Authorization")
public class UserController {

    @PostMapping
    public ResponseEntity<UserEntity> saveBrand(@RequestBody UserEntity user) {
        return ResponseEntity.ok(null);
    }
}
