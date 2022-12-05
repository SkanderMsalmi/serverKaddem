package tn.esprit.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.persistance.entities.Departement;
import tn.esprit.persistance.entities.Enseignant;

@Repository
public interface EnseignantRepository extends JpaRepository<Enseignant, Integer> {
	
	List<Enseignant> findEnseignantsByDepartement(Departement departement);


}
