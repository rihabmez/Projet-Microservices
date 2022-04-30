package fr.serviceregisteryclientcomptes.repositories;

import fr.serviceregisteryclientcomptes.models.Comptes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComptesRepository extends JpaRepository<Comptes,Integer> {


}