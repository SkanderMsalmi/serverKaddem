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
import tn.esprit.persistance.entities.Equipe;
import tn.esprit.persistance.repositories.DetailEquipeRepository;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.service.interfaces.DetailEquipeService;
import tn.esprit.service.interfaces.EquipeService;
import tn.esprit.service.interfaces.EtudiantService;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ControleurEquipe")
public class EquipeController {
	@Autowired
	EquipeService eServ;
	
	@Autowired
	EtudiantService etudServ;
	
	@Autowired
	DetailEquipeService detServ;
	
	DetailEquipeRepository detRep;
	EtudiantRepository etudRep;
	
	@GetMapping("/displayEquipe/{id}")
	public Equipe displayEquipe(@PathVariable("id")int id) {
		return eServ.retrieveEquipe(id);
	}
	
	@GetMapping("/displayEquipes")
	public List<Equipe> displayAllEquipes(){
		return eServ.retrieveAllEquipes();
	}
	
	@PostMapping("/addEquipe")
	public Equipe addEquipe( @RequestBody Equipe e) {
		
	detServ.addDetailEquipe(e.getDetailEquipe());
		return eServ.addEquipe(e);
	}
	
	@PutMapping("/updateEquipe")
	public Equipe updateEquipe(@RequestBody Equipe e) {
		detServ.updateDetailEquipe(e.getDetailEquipe());
		return eServ.updateEquipe(e);
	}
	
	@DeleteMapping("/deleteEquipe/{id}")
	public void deleteEquipe(@PathVariable("id")int id) {
		eServ.removeEquipe(id);
	}
	
	@GetMapping("/checkName/{nomEquipe}")
	public boolean checkName(@PathVariable("nomEquipe")String nomEquipe) {
		return eServ.checkName(nomEquipe);
	}
}
