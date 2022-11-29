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

import tn.esprit.persistance.entities.Departement;
import tn.esprit.service.interfaces.DepartementService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@CrossOrigin(origins="http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/controllerDepartement")
public class DepartementController {
	 @Autowired
	    DepartementService departService;

	    
	    @GetMapping("/DisplayDepartements")
	    public List<Departement> DisplayDepartement() {
	        return departService.afficherDepartements();
	    }
	    
	    @GetMapping("/DisplayDepartementById/{id}")
	    public Departement displayDepartementByID(@PathVariable("id") int id) {

	        return departService.afficherDepartement(id);
	    }
	    
	    @CrossOrigin
	    @PostMapping("/AddDepartement")
	    public Departement addDepartement(@RequestBody Departement e) {
	        return departService.ajouterDepartement(e);
	    }
	    
	    @PutMapping("/UpdateDepartement")
	    public Departement updateDepartement(@RequestBody Departement e) {
	        return departService.mettreAjourDepartement(e);
	    }
	    
	    @DeleteMapping("/deleteDepartement/{idDepartement}")
	    public void deleteDepartement(@PathVariable("idDepartement") int id) {
	        departService.supprimerDepartement(id);
	    }
	
}
