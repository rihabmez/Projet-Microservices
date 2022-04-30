package fr.serviceregisteryclientcomptes.services;


import fr.serviceregisteryclientcomptes.models.Comptes;
import fr.serviceregisteryclientcomptes.repositories.ComptesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service
public class ComptesService {

    @Autowired
    private ComptesRepository comptesRepository;
    // @Autowired
    // private ClientService clientService;


    public Comptes getComptes(int id) throws Exception {
        return this.comptesRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Comptes> getComptes(){
        return  this.comptesRepository.findAll();
    }

    public void deleteComptes(int id){
        comptesRepository.deleteById(id);
    }

    public Comptes saveCompte(Comptes comptes){
        Comptes savedComptes = comptesRepository.save(comptes);
        return savedComptes;
    }

}
