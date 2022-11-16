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

import tn.esprit.persistance.entities.*;


import tn.esprit.service.interfaces.EtudiantService;

@RestController
@RequestMapping("/ControleurEtudiant")
public class EtudiantController {

	@Autowired
	EtudiantService eServ;
	

	
	@GetMapping("/displayStudent/{id}")
	public Etudiant displayStudent(@PathVariable("id")int id) {
		return eServ.retrieveEtudiant(id);
	}

	@GetMapping("/displayStudents")
	public List<Etudiant> displayAllStudents(){
		return eServ.retrieveAllEtudiants();
	}
	
	@PostMapping("/addStudent")
	public Etudiant addStudent( @RequestBody Etudiant e) {
		return eServ.addEtudiant(e);
	}
	
	@PutMapping("/updateStudent")
	public Etudiant updateStudent(@RequestBody Etudiant e) {
		return eServ.updateEtudiant(e);
	}
	
	@DeleteMapping("/deleteStudent/{id}")
	public void deleteStudent(@PathVariable("id")int id) {
		eServ.removeEtudiant(id);
	}
	
	@PostMapping("/assignEtudToDepart/{idEtudiant}/{idDepart}")
	public void assignEtudiantToDepartement(@PathVariable("idEtudiant") int idEtudiant,@PathVariable("idDepart") int idDepart) {
		try {
			eServ.assignEtudiantToDepartement(idEtudiant, idDepart);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
	}
	
	@PostMapping("/addAndAssignEtudiantToEquipeAndContract/{idEquip}/{idContrat}")
	public Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idContrat") int idContrat,@PathVariable("idEquip") int idEtudiant) {
		try {
			return eServ.addAndAssignEtudiantToEquipeAndContract(e, idContrat, idEtudiant);
		} catch (Exception e2) {
			// TODO: handle exception
			System.out.println(e2);
			return null;
		}
	}
}
