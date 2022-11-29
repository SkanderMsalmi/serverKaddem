package tn.esprit.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.Equipe;
import tn.esprit.persistance.repositories.DetailEquipeRepository;
import tn.esprit.persistance.repositories.EquipeRepository;
import tn.esprit.service.interfaces.DetailEquipeService;
import tn.esprit.service.interfaces.EquipeService;

@Service
public class EquipeServiceImpl implements EquipeService{
	
	@Autowired
	EquipeRepository equipRep;
	
	@Autowired
	DetailEquipeRepository detRep;
	
	
	@Override
	public List<Equipe> retrieveAllEquipes() {
		// TODO Auto-generated method stub
		List<Equipe> equipes = (List<Equipe>) equipRep.findAll();
		return equipes;
	}

	@Override
	public Equipe addEquipe(Equipe e) {
		// TODO Auto-generated method stub
		
		return equipRep.save(e);
	}

	@Override
	public Equipe updateEquipe(Equipe e) {
		// TODO Auto-generated method stub
		

		
		return equipRep.save(e);
	}

	@Override
	public Equipe retrieveEquipe(Integer idEquipe) {
		// TODO Auto-generated method stub
		return equipRep.findById(idEquipe).get();
	}

	@Override
	public void removeEquipe(Integer idEquipe) {
		// TODO Auto-generated method stub
		Equipe e = equipRep.findById(idEquipe).get();
		detRep.delete(e.getDetailEquipe());
		equipRep.deleteById(idEquipe);
	}

}
