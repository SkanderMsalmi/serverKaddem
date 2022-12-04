package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Enseignant;

public interface EnseignantService {
	List<Enseignant> retrieveAllEnseignants();
	Enseignant addEnseignant(Enseignant e);
	Enseignant updateEnseignant(Enseignant e);
	Enseignant retrieveEnseignant(Integer idEnseignant);
	void removeEnseignant(Integer idEnseignant);
	
	//Enseignant removeFromDepartement(Integer idEnseignant);
	
	
	List<Enseignant> getEnseignantsByDepartement (Integer idDepartement);
	public void assignEnseignantToDepartement (Integer idEnseignant, Integer idDepart) ;
	

}
