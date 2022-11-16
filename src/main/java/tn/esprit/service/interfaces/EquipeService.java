package tn.esprit.service.interfaces;

import java.util.List;

import tn.esprit.persistance.entities.Equipe;

public interface EquipeService {
	List<Equipe> retrieveAllEquipes();
	Equipe addEquipe(Equipe e);
	Equipe updateEquipe(Equipe e);
	Equipe retrieveEquipe(Integer idEquipe);
	void removeEquipe(Integer idEquipe);

}
