package tn.esprit.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.Departement;
import tn.esprit.persistance.entities.Enseignant;
import tn.esprit.persistance.entities.Equipe;
import tn.esprit.persistance.entities.Etudiant;
import tn.esprit.persistance.repositories.DepartementRepository;
import tn.esprit.persistance.repositories.EnseignantRepository;
import tn.esprit.service.interfaces.EnseignantService;


@Service
public class EnseignantServiceImpl implements EnseignantService { 

	
	
	
	
	

	
	
	@Autowired
	EnseignantRepository ensRep;
	
	@Autowired
	DepartementRepository depRep;

	@Override
	public List<Enseignant> retrieveAllEnseignants() {
		List <Enseignant> enseignants=(List<Enseignant>)ensRep.findAll();
		return enseignants;
	}

	
	
	@Override
	public Enseignant addEnseignant(Enseignant e) {
	
		return ensRep.save(e);
	}

	@Override
	public Enseignant updateEnseignant(Enseignant e) {
		return ensRep.save(e);	
		}

	@Override
	public Enseignant retrieveEnseignant(Integer idEnseignant) {
            Enseignant e = ensRep.findById(idEnseignant).get();
		return e;
	}

	@Override
	public void removeEnseignant(Integer idEnseignant) {
		ensRep.deleteById(idEnseignant);

		
	}
	
	
	



	@Override
	public List<Enseignant> getEnseignantsByDepartement(Integer idDepartement) {
		Departement departement=depRep.findById(idDepartement).get();
		return ensRep.findEnseignantsByDepartement(departement);
	}

	@Override
	public void assignEnseignantToDepartement(Integer idDepart,Integer idEnseignant) {
		Enseignant enseignant=ensRep.findById(idEnseignant).orElse(null);
		 Departement departement=depRep.findById(idDepart).orElse(null);
		 enseignant.setDepartement(departement);
		 ensRep.save(enseignant);
		
		
	}

	@Override
	public void unassignEnseignantFromDepartement(Integer idDepart, Integer idEnseignant) {
		// TODO Auto-generated method stub
		Enseignant ens = ensRep.findById(idEnseignant).get();
		
		Departement dept = depRep.findById(idDepart).get();
	
		
		ens.setDepartement(null);
		ensRep.save(ens);
	}

	//@Override
	//public Enseignant removeFromDepartement(Integer idEnseignant) {
     //   Enseignant e = ensRep.findById(idEnseignant).get();
        
      //  e.setDepartement(null);
	//	return e;
	//}
	
	
	
	
	

	

}
