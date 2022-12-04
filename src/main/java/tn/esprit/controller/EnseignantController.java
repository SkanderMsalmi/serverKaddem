package tn.esprit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.persistance.entities.Enseignant;
import tn.esprit.service.interfaces.EnseignantService;


@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/controllerEnseignant")
public class EnseignantController {
	
	@Autowired
	EnseignantService ensDep; 
	
	
	@GetMapping("/DisplayEnseignants")
    public List<Enseignant> DisplayEnseignant() {
        return ensDep.retrieveAllEnseignants();
    }
    
    @GetMapping("/DisplayEnseignantById/{id}")
    public Enseignant displayEnseignantByID(@PathVariable("id") int id) {

        return ensDep.retrieveEnseignant(id);
    }
    
    @CrossOrigin
    @PostMapping("/AddEnseignant")
    public Enseignant addEnseignant(@RequestBody Enseignant e) {
        return ensDep.addEnseignant(e);
    }
    
    @PutMapping("/UpdateEnseignant")
    public Enseignant updateEnseignant(@RequestBody Enseignant e) {
        return ensDep.updateEnseignant(e);
    }
    
    @DeleteMapping("/deleteEnseignant/{idEnseignant}")
    public void deleteEnseignant(@PathVariable("idEnseignant") int id) {
        ensDep.removeEnseignant(id);
    }
    
    @PutMapping("assignEnseignantDepartement/{iddep}/{idEns}")
    public void assignEnseignantDepartement(@PathVariable("iddep") Integer idDepratement, @PathVariable("idEns") Integer idEnseignant) {
    	ensDep.assignEnseignantToDepartement(idDepratement, idEnseignant);
    }
    
    
  //  @PutMapping("removeFromDepartement/{idEns}")
    //public void removeFromDepartement( @PathVariable("idEns") Integer idEnseignant) {
    	//ensDep.removeFromDepartement(idEnseignant);
   // }
    
    
    

    @GetMapping("getEnseignantDepartement/{iddep}")
    public List<Enseignant> retrieveEnseignantDepartement(@PathVariable("iddep") Integer idDepartement){
    	return ensDep.getEnseignantsByDepartement(idDepartement);
    }


}
