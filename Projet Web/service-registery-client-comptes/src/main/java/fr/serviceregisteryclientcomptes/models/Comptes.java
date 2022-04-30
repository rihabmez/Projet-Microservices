package fr.serviceregisteryclientcomptes.models;
import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comptes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcompte;
    private String nom;
    private String prenom;
    private String email;
    private String password;
    @JsonCreator
    public Comptes(int id) {
        this.idcompte = id;
    }
}
