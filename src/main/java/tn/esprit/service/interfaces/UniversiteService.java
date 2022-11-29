package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Universite;

public interface UniversiteService {
	List<Universite> retrieveAllUniversites();
	Universite addUniversite(Universite e);
	Universite updateUniversite(Universite e);
	Universite retrieveUniversite(Integer idUniversite);
	void removeUniversite(Integer idUniversite);
	public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement);
}
