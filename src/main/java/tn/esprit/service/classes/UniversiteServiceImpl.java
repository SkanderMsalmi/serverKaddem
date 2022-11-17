package tn.esprit.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.Departement;
import tn.esprit.persistance.entities.Universite;
import tn.esprit.persistance.repositories.DepartementRepository;
import tn.esprit.persistance.repositories.UniversiteRepository;
import tn.esprit.service.interfaces.UniversiteService;

@Service
public class UniversiteServiceImpl implements UniversiteService {
	
	@Autowired
	UniversiteRepository univRep;
	
	@Autowired
	DepartementRepository depRep;
	
	@Override
	public List<Universite> retrieveAllUniversites() {
		// TODO Auto-generated method stub
		List<Universite> universites = (List<Universite>) univRep.findAll();

		return universites;
	}

	@Override
	public Universite addUniversite(Universite e) {
		// TODO Auto-generated method stub
		return univRep.save(e);
	}

	@Override
	public Universite updateUniversite(Universite e) {
		// TODO Auto-generated method stub
		return univRep.save(e);
	}

	@Override
	public Universite retrieveUniversite(Integer idUniversite) {
		// TODO Auto-generated method stub
		return univRep.findById(idUniversite).get();
	}

	@Override
	public void removeUniversite(Integer idUniversite) {
		// TODO Auto-generated method stub
		univRep.deleteById(idUniversite);
	}

	@Override
	public void assignUniversiteToDepartement(Integer idUniversite, Integer idDepartement) {
		// TODO Auto-generated method stub
		Universite u = univRep.findById(idUniversite).get();
		Departement d = depRep.findById(idDepartement).get();
		u.getDepartements().add(d);
		univRep.save(u);
		
;	}

}
