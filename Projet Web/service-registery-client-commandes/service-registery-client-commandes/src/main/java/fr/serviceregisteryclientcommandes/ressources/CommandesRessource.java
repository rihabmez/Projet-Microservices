package fr.serviceregisteryclientcommandes.ressources;

import fr.serviceregisteryclientcommandes.models.Commandes;
import fr.serviceregisteryclientcommandes.repositories.CommandesRepository;
import fr.serviceregisteryclientcommandes.services.CommandesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("commandes")
public class CommandesRessource {
    // @Autowired
    // private ClientRepository cp ;

    @Autowired
    private CommandesService commandesService;

    @Autowired
    private CommandesRepository commandesRepository;

    @GetMapping()
    public List<Commandes> getCommandes(){
        return this.commandesService.getCommandes();
    }

    @GetMapping("{id}")
    public Commandes getCommandes(@PathVariable("id") int id) throws Exception {
        return commandesService.getCommandes(id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteCommandes(@PathVariable("id") int id) {
        commandesService.deleteCommandes(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Commandes> createCommandes(@RequestBody Commandes commandes) {
        try {
            Commandes _commandes = commandesRepository
                    .save(new Commandes(commandes.getIdcommande(), commandes.getIdproduit(), commandes.getIdclient()));
            return new ResponseEntity<>(_commandes, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@PostMapping
    public commandes createcommandes(@RequestBody commandesCreateModel commandesToCreate) throws Exception {
        return this.commandesRepository.save(commandesToCreate.getcommandes());
    }*/


}
