package co.com.jdti.tech.vehicleapi.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.jdti.tech.vehicleapi.model.entities.VehicleType;
import co.com.jdti.tech.vehicleapi.services.VehicleTypeServices;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin({ "*" })
@RequestMapping("/vehicle-type")
@RequiredArgsConstructor
public class VehicleTypeController {

    private final VehicleTypeServices vehicleTypeServices;

    @GetMapping
    public ResponseEntity<List<VehicleType>> getVehicle() {
        List<VehicleType> vehicleTypes = vehicleTypeServices.findAll();
        if (vehicleTypes.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehicleTypes);
    }

    @PostMapping
    public ResponseEntity<VehicleType> getVehicle(@Valid @RequestBody VehicleType vehicleType, BindingResult result) {
        vehicleType.setId(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleTypeServices.save(vehicleType));
    }

    @PutMapping
    public ResponseEntity<VehicleType> editVehicle(@Valid @RequestBody VehicleType vehicleType, BindingResult result) {
        if (vehicleType.getId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        } else if (vehicleTypeServices.findById(vehicleType.getId()) == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        return ResponseEntity.status(HttpStatus.OK).body(vehicleTypeServices.save(vehicleType));
    }

    @DeleteMapping
    public ResponseEntity<VehicleType> deleteVehicle(@RequestParam String vehicleTypeId) {
        if (vehicleTypeServices.findById(Long.parseLong(vehicleTypeId)) == null) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
        }
        vehicleTypeServices.deleteVehicleType(Long.parseLong(vehicleTypeId));
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}
