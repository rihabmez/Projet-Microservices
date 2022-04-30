package fr.serviceregisteryclientcommandes.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Commandes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idcommande;
    private Integer idproduit;
    private Integer idclient;
    @JsonCreator
    public Commandes(int id) {
        this.idcommande = id;
    }
}
