package tn.esprit.service.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.persistance.entities.DetailEquipe;
import tn.esprit.persistance.repositories.DetailEquipeRepository;
import tn.esprit.service.interfaces.DetailEquipeService;

@Service
public class DetailEquipeServiceImpl implements DetailEquipeService{
	
	@Autowired
	DetailEquipeRepository detEquipRep;
	
	@Override
	public List<DetailEquipe> retrieveAllDetailEquipes() {
		// TODO Auto-generated method stub
		List<DetailEquipe> detailequipes = (List<DetailEquipe>) detEquipRep.findAll();
		return detailequipes;
	}

	@Override
	public DetailEquipe addDetailEquipe(DetailEquipe e) {
		// TODO Auto-generated method stub
		return detEquipRep.save(e);
	}

	@Override
	public DetailEquipe updateDetailEquipe(DetailEquipe e) {
		// TODO Auto-generated method stub
		return detEquipRep.save(e);
	}

	@Override
	public DetailEquipe retrieveDetailEquipe(Integer idDetailEquipe) {
		// TODO Auto-generated method stub
		return detEquipRep.findById(idDetailEquipe).get();
	}

	@Override
	public void removeDetailEquipe(Integer idDetailEquipe) {
		// TODO Auto-generated method stub
		detEquipRep.deleteById(idDetailEquipe);
	}

}
