package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Contrat;
import tn.esprit.persistance.entities.Departement;

public interface ContratService {
	List<Contrat> retrieveAllContrats();
	Contrat addContrat(Contrat e);
	Contrat updateContrat(Contrat e);
	Contrat retrieveContrat(Integer idContrat);
	void removeContrat(Integer idContrat);
	Contrat affectContratToEtudiant (Contrat ce, String nomE, String prenomE);
    public List<Contrat> retrieveContratByEtuId(Integer idEtudiant);

}
