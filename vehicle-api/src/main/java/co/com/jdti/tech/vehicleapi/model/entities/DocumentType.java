package co.com.jdti.tech.vehicleapi.model.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "document_type")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false, updatable = false)
    private Long id;

    @NotEmpty(message = "La descripcion es obligatoria.")
    @Column(name = "description", nullable = false, unique = true)
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "documentType")
    private List<UserEntity> users;

    public void addUser(UserEntity users) {
        if (this.users == null) {
            this.users = new ArrayList<>();
        }
        this.users.add(users);
    }
}
