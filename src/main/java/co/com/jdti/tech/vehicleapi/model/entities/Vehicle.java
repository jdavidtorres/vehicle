package co.com.jdti.tech.vehicleapi.model.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_type_id")
    private VehicleType vehicleType;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @Range(min = 1900, max = 3000)
    private int model;

    @Pattern(regexp = "[a-zA-Z]{3}[0-9]{2}[a-zA-Z0-9]")
    @Column(unique = true)
    private String plaque;

    private String line;

    private String color;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity owner;
}
