package tn.esprit.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.Contrat;
import tn.esprit.persistance.entities.Etudiant;
import tn.esprit.persistance.repositories.ContratRepository;
import tn.esprit.persistance.repositories.EtudiantRepository;
import tn.esprit.service.interfaces.ContratService;

@Service
public class ConrtatServiceImpl implements ContratService{
	
	
	@Autowired
	ContratRepository contRep;
	
	@Autowired
	EtudiantRepository etudRep;
	
	@Override
	public List<Contrat> retrieveAllContrats() {
		List<Contrat> contrats = (List<Contrat>) contRep.findAll();
		return contrats;
	}

	@Override
	public Contrat addContrat(Contrat e) {
		// TODO Auto-generated method stub
		return contRep.save(e);
	}

	@Override
	public Contrat updateContrat(Contrat e) {
		// TODO Auto-generated method stub
		return contRep.save(e);
	}

	@Override
	public Contrat retrieveContrat(Integer idContrat) {
		// TODO Auto-generated method stub
		return contRep.findById(idContrat).get();
	}

	@Override
	public void removeContrat(Integer idContrat) {
		// TODO Auto-generated method stub
		contRep.deleteById(idContrat);
	}

	@Override
	public Contrat affectContratToEtudiant(Contrat ce, String nomE, String prenomE) {
		// TODO Auto-generated method stub
		if(nomE.isEmpty() || prenomE.isEmpty()) {
			return null;
		}else {
			Etudiant e = etudRep.findEtuidantByNomAndPrenom(nomE,prenomE);
			ce.setEtudiant(e);
			
				return contRep.save(ce);
		}

	}

}
