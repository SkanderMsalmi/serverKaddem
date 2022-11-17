package tn.esprit.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.Contrat;
import tn.esprit.persistance.entities.Departement;
import tn.esprit.persistance.entities.Equipe;
import tn.esprit.persistance.entities.Etudiant;
import tn.esprit.persistance.repositories.ContratRepository;
import tn.esprit.persistance.repositories.DepartementRepository;
import tn.esprit.persistance.repositories.EquipeRepository;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.service.interfaces.EtudiantService;

@Service
public class EtudiantServiceImpl implements EtudiantService{
	
	@Autowired
	EtudiantRepository etudRep;
	
	@Autowired
	DepartementRepository departRep;
	
	@Autowired
	ContratRepository contRep;
	
	@Autowired
	EquipeRepository equipRep;
	
	@Override
	public List<Etudiant> retrieveAllEtudiants() {
		// TODO Auto-generated method stub
	List<Etudiant> etudiants = (List<Etudiant>)etudRep.findAll();
		
		return etudiants ;
	}

	@Override
	public Etudiant addEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		return etudRep.save(e);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		// TODO Auto-generated method stub
		etudRep.save(e);
		return e;
	}

	@Override
	public Etudiant retrieveEtudiant(Integer idEtudiant) {
		// TODO Auto-generated method stub
		Etudiant e = etudRep.findById(idEtudiant).get();
		
		return e;
	}

	@Override
	public void removeEtudiant(Integer idEtudiant) {
		// TODO Auto-generated method stub
		etudRep.deleteById(idEtudiant);
		
	}

	@Override
	public void assignEtudiantToDepartement(Integer idEtudiant, Integer idDepart) {
		Etudiant e = etudRep.findById(idEtudiant).get();
		Departement d = departRep.findById(idDepart).get();
		e.setDepartement(d);
		etudRep.save(e);
	}

	@Override
	public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, Integer idEquipe) {
		// TODO Auto-generated method stub
		 Etudiant etud = etudRep.save(e);
		 Contrat c = contRep.findById(idContrat).get();
		 Equipe equip = equipRep.findById(idEquipe).get();
		 c.setEtudiant(e);
		 equip.getEtudiants().add(e);
		 contRep.save(c);
		 equipRep.save(equip);
		return etud;
		
	}

	@Override
	public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
		// TODO Auto-generated method stub
		Departement d = departRep.findById(idDepartement).get();
		
		
		return null;
	}

//	@Override
//	public List<Etudiant> getEtudiantsByDepartement(Integer idDepartement) {
//		List<Etudiant> etudiants = etudRep.findEtuidantByDepartement(idDepartement);
//		return etudiants;
//	}





}
