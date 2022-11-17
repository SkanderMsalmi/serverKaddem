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

import tn.esprit.persistance.entities.Contrat;
import tn.esprit.service.interfaces.ContratService;

@RestController
@RequestMapping("/ControleurContrat")
public class ContratController {

	@Autowired
	ContratService CServ;
	
	@GetMapping("/displayContrat/{id}")
	public Contrat displayContrat(@PathVariable("id") int id) {
		return CServ.retrieveContrat(id);
	}
	
	@GetMapping("/displayContrats")
	public List<Contrat> displayAllContrats(){
		return CServ.retrieveAllContrats();
	}
	
	@PostMapping("/addContrat")
	public Contrat addContrat( @RequestBody Contrat e) {
		return CServ.addContrat(e);
	}
	
	@PutMapping("/updateContrat")
	public Contrat updateContrat(@RequestBody Contrat e) {
		return CServ.updateContrat(e);
	}
	
	@DeleteMapping("/deleteContrat/{id}")
	public void deleteContrat(@PathVariable("id")int id) {
		CServ.removeContrat(id);
	}
	
	@PostMapping("/affectContratToEtudiant/{nomE}/{prenomE}")
	public Contrat affectContratToEtudiant(@RequestBody Contrat c,@PathVariable("nomE") String nomE,@PathVariable("prenomE") String prenomE) {
		return CServ.affectContratToEtudiant(c, nomE, prenomE);
	}
}
