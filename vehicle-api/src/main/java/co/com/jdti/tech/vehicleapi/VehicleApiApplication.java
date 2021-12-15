package co.com.jdti.tech.vehicleapi;

import co.com.jdti.tech.vehicleapi.helpers.TokenHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import co.com.jdti.tech.vehicleapi.enums.UserType;
import co.com.jdti.tech.vehicleapi.model.entities.Brand;
import co.com.jdti.tech.vehicleapi.model.entities.DocumentType;
import co.com.jdti.tech.vehicleapi.model.entities.Procedure;
import co.com.jdti.tech.vehicleapi.model.entities.Role;
import co.com.jdti.tech.vehicleapi.model.entities.UserEntity;
import co.com.jdti.tech.vehicleapi.model.entities.VehicleType;
import co.com.jdti.tech.vehicleapi.repositories.IBrandRepository;
import co.com.jdti.tech.vehicleapi.repositories.IDocumentTypeRepository;
import co.com.jdti.tech.vehicleapi.repositories.IProcedureRepository;
import co.com.jdti.tech.vehicleapi.repositories.IRoleRepository;
import co.com.jdti.tech.vehicleapi.repositories.IUserRepository;
import co.com.jdti.tech.vehicleapi.repositories.IVehicleTypeRepository;

@SpringBootApplication
public class VehicleApiApplication implements CommandLineRunner {

    @Autowired
    private IVehicleTypeRepository iVehicleTypeRepository;

    @Autowired
    private IDocumentTypeRepository iDocumentTypeRepository;

    @Autowired
    private IBrandRepository iBrandRepository;

    @Autowired
    private IProcedureRepository iProcedureRepository;

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IRoleRepository iRoleRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        SpringApplication.run(VehicleApiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        init();
    }

    private void init() {
        iVehicleTypeRepository.save(VehicleType.builder().description("Car").build());
        iVehicleTypeRepository.save(VehicleType.builder().description("Motorcycle").build());
        iVehicleTypeRepository.save(VehicleType.builder().description("Truck").build());
        iVehicleTypeRepository.save(VehicleType.builder().description("Bus").build());

        iDocumentTypeRepository.save(DocumentType.builder().description("Pasaporte").build());
        DocumentType cc = iDocumentTypeRepository
                .save(DocumentType.builder().description("Cédula de ciudadanía").build());
        iDocumentTypeRepository.save(DocumentType.builder().description("Cédula de extranjería").build());
        iDocumentTypeRepository.save(DocumentType.builder().description("Tarjeta de identidad").build());
        iDocumentTypeRepository.save(DocumentType.builder().description("NIT").build());

        iBrandRepository.save(Brand.builder().description("Chevrolet").build());
        iBrandRepository.save(Brand.builder().description("Toyota").build());
        iBrandRepository.save(Brand.builder().description("Nissan").build());
        iBrandRepository.save(Brand.builder().description("Ducati").build());
        iBrandRepository.save(Brand.builder().description("KTM").build());
        iBrandRepository.save(Brand.builder().description("Yamaha").build());
        iBrandRepository.save(Brand.builder().description("Honda").build());
        iBrandRepository.save(Brand.builder().description("TVS").build());
        iBrandRepository.save(Brand.builder().description("Suzuki").build());
        iBrandRepository.save(Brand.builder().description("Ford").build());
        iBrandRepository.save(Brand.builder().description("BMW").build());
        iBrandRepository.save(Brand.builder().description("Kawasaki").build());
        iBrandRepository.save(Brand.builder().description("Harley Davidson").build());
        iBrandRepository.save(Brand.builder().description("Mercedes Benz").build());

        iProcedureRepository.save(Procedure.builder().description("Alineación").price(10000.0).build());
        iProcedureRepository.save(Procedure.builder().description("Cambio de aceite").price(10000.0).build());
        iProcedureRepository.save(Procedure.builder().description("Cambio de filtro de aire").price(10000.0).build());
        iProcedureRepository
                .save(Procedure.builder().description("Lubricación de suspención delantera").price(10000.0).build());
        iProcedureRepository
                .save(Procedure.builder().description("Lubricación de suspención trasera").price(10000.0).build());
        iProcedureRepository.save(Procedure.builder().description("Frenos delanteros").price(1000.0).build());
        iProcedureRepository.save(Procedure.builder().description("Frenos traseros").price(10000.0).build());
        iProcedureRepository.save(Procedure.builder().description("Cambio de llanta delantera").price(1000.0).build());
        iProcedureRepository.save(Procedure.builder().description("Cambio de llanta trasera").price(10000.0).build());
        iProcedureRepository.save(Procedure.builder().description("Calibración de válvulas").price(10000.0).build());
        iProcedureRepository.save(Procedure.builder().description("Aceite motor").price(10000.0).build());
        iProcedureRepository.save(Procedure.builder().description("Aceite caja").price(1000.0).build());
        iProcedureRepository.save(Procedure.builder().description("Aceite hidráulico").price(10000.0).build());
        iProcedureRepository.save(Procedure.builder().description("Kit de arrastre").price(1000000.0).build());
        iProcedureRepository.save(Procedure.builder().description("Accesorios").price(1000.0).build());

        Role adminRole = iRoleRepository.save(Role.builder().roleName(UserType.Admin.name()).build());
        Role userRole = iRoleRepository.save(Role.builder().roleName(UserType.User.name()).build());

        iUserRepository.save(UserEntity.builder().firstName("Juan").lastName("Perez").documentType(cc)
                .documentNumber("123456789").email("juan@yopmail.com").password(passwordEncoder.encode("12345"))
                .address("Avenue 745").role(adminRole).build());

        System.out.println(TokenHelper.generateToken("juan@yopmail.com"));

        iUserRepository.save(UserEntity.builder().firstName("Juan").lastName("Perez").documentType(cc)
                .documentNumber("123456789").email("luis@yopmail.com").password(passwordEncoder.encode("12345"))
                .address("Avenue 745").role(userRole).build());
    }
}
