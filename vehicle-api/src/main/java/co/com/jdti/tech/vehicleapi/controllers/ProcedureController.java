package co.com.jdti.tech.vehicleapi.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.jdti.tech.vehicleapi.model.entities.Procedure;
import lombok.RequiredArgsConstructor;

@RestController
@CrossOrigin({ "*" })
@RequestMapping("/procedures")
@RequiredArgsConstructor
public class ProcedureController {

    @PostMapping
    public ResponseEntity<Procedure> createProcedure(@RequestBody Procedure procedure) {
        return ResponseEntity.ok(new Procedure());
    }
}
