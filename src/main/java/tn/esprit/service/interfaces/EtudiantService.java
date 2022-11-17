package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Etudiant;

public interface EtudiantService {
	List<Etudiant> retrieveAllEtudiants();
	Etudiant addEtudiant(Etudiant e);
	Etudiant updateEtudiant(Etudiant e);
	Etudiant retrieveEtudiant(Integer idEtudiant);
	void removeEtudiant(Integer idEtudiant);
	
	
	
	
	List<Etudiant> getEtudiantsByDepartement (Integer idDepartement);
	public void assignEtudiantToDepartement (Integer idEtudiant, Integer idDepart) ;
	Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat,Integer idEquipe);
}
