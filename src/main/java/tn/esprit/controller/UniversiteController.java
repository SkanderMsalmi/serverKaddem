package tn.esprit.controller;
import java.util.List;

import javax.validation.Valid;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import tn.esprit.persistance.entities.Universite;
import tn.esprit.service.interfaces.DepartementService;
import tn.esprit.service.interfaces.UniversiteService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ControleurUniversite")
public class UniversiteController {
	@Autowired
	UniversiteService eServ;
	
	@Autowired
	DepartementService depServ;
	
	@GetMapping("/displayUniversite/{id}")
	public Universite displayUniversite(@PathVariable("id")int id) {
		return eServ.retrieveUniversite(id);
	}
	
	@GetMapping("/displayUniversites")
	public List<Universite> displayAllUniversites(){
		return eServ.retrieveAllUniversites();
	}
	
	@PostMapping("/addUniversite")
	public Universite addUniversite(@Valid @RequestBody Universite e) {
		
		
		return eServ.addUniversite(e);
	}
	@PutMapping("/updateUniversite/{id}")
	    public ResponseEntity<?> update(@Valid @RequestBody Universite universite, @PathVariable Integer id) {
	        try {
	            eServ.retrieveUniversite(id);
	            universite.setIdUniv(id);
	            eServ.addUniversite(universite);
	            return new ResponseEntity<>(HttpStatus.OK);
	        } catch (NoSuchElementException e) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }
	@DeleteMapping("/deleteUniversite/{id}")
	public void deleteUniversite(@PathVariable("id")int id) {
		eServ.removeUniversite(id);
	}
	
	@PostMapping("{idUniv}/assignUniversiteToDepartement/{idDep}")
	public void assignUniversiteToDepartement(@PathVariable("idUniv")int idUniv,@PathVariable("idDep")int idDept) {
		eServ.assignUniversiteToDepartement(idUniv, idDept);
	}
	
    @PostMapping("/unassignDeapartementFromUniversite/{idUniv}/{idDep}")
    public void unassignDeapartementFromUniversite(@PathVariable("idUniv") int idUniversite,@PathVariable("idDep")int idDepartement) {
    try {
    eServ.unassignDeapartementFromUniversite(idDepartement, idUniversite);
    } catch (Exception e) {
    // TODO: handle exception
    System.out.println(e.toString());
    }
    }
}
