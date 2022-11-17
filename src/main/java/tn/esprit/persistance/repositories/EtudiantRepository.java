package tn.esprit.persistance.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.esprit.persistance.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{
	
	@Query("SELECT e FROM Etudiant e WHERE e.nomE =: nomE")
	Etudiant findEtuidantByNom(@Param("nomE") String nomE);
	
	
	@Query("SELECT e FROM Etudiant e WHERE e.prenomE =: prenomE")
	Etudiant findEtuidantByPrenom(@Param("prenomE") String prenomE);
	
	@Query("SELECT e FROM Etudiant e WHERE  e.nomE =: nome and e.prenomE =: prenome")
	Etudiant findEtuidantByNomAndPrenom(@Param("nomE") String nome,@Param("prenomE") String prenome);
	

	
}
