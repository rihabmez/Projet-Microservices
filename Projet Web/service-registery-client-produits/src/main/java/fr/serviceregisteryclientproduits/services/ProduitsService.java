package fr.serviceregisteryclientproduits.services;

import fr.serviceregisteryclientproduits.models.Produits;
import fr.serviceregisteryclientproduits.repositories.ProduitsRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service
public class ProduitsService {

    @Autowired
    private ProduitsRepository produitsRepository;
   // @Autowired
   // private ClientService clientService;


    public Produits getProduits(int id) throws Exception {
        return this.produitsRepository.findById(id).orElseThrow(Exception::new);
    }

    public List<Produits> getProduits(){
        return  this.produitsRepository.findAll();
    }

    public void deleteProduits(int id){

        produitsRepository.deleteById(id);
    }

    public Produits saveProduits(Produits produits){
        Produits savedProduits = produitsRepository.save(produits);
        return savedProduits;
    }

}
