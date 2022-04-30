package fr.serviceregisteryclientcommandes.services;

import fr.serviceregisteryclientcommandes.models.Commandes;
import fr.serviceregisteryclientcommandes.repositories.CommandesRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Data
@Service
public class  CommandesService {

    @Autowired
    private  CommandesRepository  commandesRepository;
    // @Autowired
    // private ClientService clientService;


    public  Commandes getCommandes(int id) throws Exception {
        return this.commandesRepository.findById(id).orElseThrow(Exception::new);
    }

    public List< Commandes> getCommandes(){
        return  this.commandesRepository.findAll();
    }

    public void deleteCommandes(int id){

         commandesRepository.deleteById(id);
    }

    public  Commandes saveCommandes( Commandes  commandes){
         Commandes savedCommandes =  commandesRepository.save(commandes);
        return savedCommandes;
    }

}
