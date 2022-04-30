package fr.serviceregisteryclientproduits.models;


import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Produits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idproduit;
    private String nom;
    private Integer codebarre;
    private Integer prix;
    @JsonCreator
    public Produits(int id) {
        this.idproduit = id;
    }
}