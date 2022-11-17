package tn.esprit.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

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
	public Universite addUniversite( @RequestBody Universite e) {
		
		e.getDepartements().forEach(
				(d)->{
					depServ.addDepartement(d);
				}
				);
		return eServ.addUniversite(e);
	}
	
	@PutMapping("/updateUniversite")
	public Universite updateUniversite(@RequestBody Universite e) {
		return eServ.updateUniversite(e);
	}
	
	@DeleteMapping("/deleteUniversite/{id}")
	public void deleteUniversite(@PathVariable("id")int id) {
		eServ.removeUniversite(id);
	}
	
	@PostMapping("{idUniv}/assignUniversiteToDepartement/{idDep}")
	public void assignUniversiteToDepartement(@PathVariable("idUniv")int idUniv,@PathVariable("idDep")int idDept) {
		eServ.assignUniversiteToDepartement(idUniv, idDept);
	}
}
