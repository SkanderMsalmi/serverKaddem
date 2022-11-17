package tn.esprit.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.Departement;
import tn.esprit.persistance.entities.Etudiant;
import tn.esprit.persistance.repositories.DepartementRepository;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.service.interfaces.DepartementService;

@Service
public class DepartementServiceImpl implements DepartementService{
	
	@Autowired
	DepartementRepository depRep;
	
	@Autowired
	EtudiantRepository etudRep;
	
	@Override
	public List<Departement> retrieveAllDepartements() {
		List<Departement> departements = (List<Departement>) depRep.findAll();
		return departements;
	}
	
	@Override
	public Departement addDepartement(Departement e) {
		// TODO Auto-generated method stub
		return depRep.save(e);
	}

	@Override
	public Departement updateDepartement(Departement e) {
		// TODO Auto-generated method stub
		return depRep.save(e);
	}

	@Override
	public Departement retrieveDepartement(Integer idDepartement) {
		// TODO Auto-generated method stub
		return depRep.findById(idDepartement).get();
	}

	@Override
	public void removeDepartement(Integer idDepartement) {
		// TODO Auto-generated method stub
		depRep.deleteById(idDepartement);
	}

	

	

}
