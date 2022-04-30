package fr.serviceregisteryclientcomptes.ressources;

import fr.serviceregisteryclientcomptes.models.Comptes;
import fr.serviceregisteryclientcomptes.repositories.ComptesRepository;
import fr.serviceregisteryclientcomptes.services.ComptesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comptes")
public class ComptesRessource {
    // @Autowired
    // private ClientRepository cp ;

    @Autowired
    private ComptesService comptesService;

    @Autowired
    private ComptesRepository comptesRepository;

    @GetMapping()
    public List<Comptes> getComptes(){
        return this.comptesService.getComptes();
    }

    @GetMapping("{id}")
    public Comptes getcomptes(@PathVariable("id") int id) throws Exception {
        return comptesService.getComptes(id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteComptes(@PathVariable("id") int id) {
        comptesService.deleteComptes(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Comptes> createComptes(@RequestBody Comptes comptes) {
        try {
            Comptes _comptes = comptesRepository
                    .save(new Comptes(comptes.getIdcompte() ,comptes.getNom(), comptes.getPrenom(),comptes.getEmail(),comptes.getPassword()));
            return new ResponseEntity<>(_comptes, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@PostMapping
    public comptes createcomptes(@RequestBody comptesCreateModel comptesToCreate) throws Exception {
        return this.comptesRepository.save(comptesToCreate.getcomptes());
    }*/


}
