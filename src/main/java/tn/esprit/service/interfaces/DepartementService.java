package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Departement;
import tn.esprit.persistance.entities.Etudiant;

public interface DepartementService {
	List<Departement> retrieveAllDepartements();
	Departement addDepartement(Departement e);
	Departement updateDepartement(Departement e);
	Departement retrieveDepartement(Integer idDepartement);
	void removeDepartement(Integer idDepartement);


}
