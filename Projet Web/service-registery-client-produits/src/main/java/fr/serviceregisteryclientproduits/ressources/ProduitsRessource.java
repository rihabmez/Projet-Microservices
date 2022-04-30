package fr.serviceregisteryclientproduits.ressources;
import fr.serviceregisteryclientproduits.models.Produits;
import fr.serviceregisteryclientproduits.repositories.ProduitsRepository;
import fr.serviceregisteryclientproduits.services.ProduitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produits")
public class ProduitsRessource {
   // @Autowired
   // private ClientRepository cp ;

    @Autowired
    private ProduitsService produitsService;

    @Autowired
    private ProduitsRepository produitsRepository;

    @GetMapping()
    public List<Produits> getProduits(){
        return this.produitsService.getProduits();
    }

    @GetMapping("{id}")
    public Produits getProduits(@PathVariable("id") int id) throws Exception {
        return produitsService.getProduits(id);
    }
    @DeleteMapping("{id}")
    public ResponseEntity deleteProduits(@PathVariable("id") int id) {
        produitsService.deleteProduits(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Produits> createProduits(@RequestBody Produits produits) {
        try {
            Produits _produits = produitsRepository
                    .save(new Produits(produits.getIdproduit() ,produits.getNom(), produits.getCodebarre(),produits.getPrix()));
            return new ResponseEntity<>(_produits, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*@PostMapping
    public Produits createProduits(@RequestBody ProduitsCreateModel ProduitsToCreate) throws Exception {
        return this.produitsRepository.save(ProduitsToCreate.getProduits());
    }*/


}
