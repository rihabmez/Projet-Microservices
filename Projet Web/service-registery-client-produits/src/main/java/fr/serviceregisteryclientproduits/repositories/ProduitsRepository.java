package fr.serviceregisteryclientproduits.repositories;

import fr.serviceregisteryclientproduits.models.Produits;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.ManyToMany;
import java.util.List;

@Repository
public interface ProduitsRepository extends JpaRepository<Produits,Integer> {


}