package co.com.jdti.tech.vehicleapi.controllers;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jdti.tech.vehicleapi.model.entities.VehicleType;

@RestController
@CrossOrigin({ "*" })
@RequestMapping("/vehicle")
public class VehicleTypeController {

    @PostMapping
    public ResponseEntity<VehicleType> getVehicle(@Valid @RequestBody VehicleType vehicleType, BindingResult result) {
        return null;
    }
}
