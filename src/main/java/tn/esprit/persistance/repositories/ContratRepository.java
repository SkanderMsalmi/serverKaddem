package tn.esprit.persistance.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.esprit.persistance.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Integer>{
	@Query(value ="SELECT * FROM contrat c where c.etudiant_id_etudiant = ?1", nativeQuery=true)
	public List<Contrat> retrieveContratByEtuId(Integer idEtudiant);
}
