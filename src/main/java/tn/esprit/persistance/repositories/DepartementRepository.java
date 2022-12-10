package tn.esprit.persistance.repositories;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tn.esprit.persistance.entities.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer>{
	@Query(value ="SELECT * FROM departement d join universite_departements  u on d.id_departement = u.departements_id_departement where u.universite_id_univ = ?1", nativeQuery=true)
	public List<Departement> retrieveDepartByUniId(Integer idUniversite);
	
	
}
