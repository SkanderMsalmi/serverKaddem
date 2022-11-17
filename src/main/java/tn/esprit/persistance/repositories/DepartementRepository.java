package tn.esprit.persistance.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import tn.esprit.persistance.entities.Departement;

@Repository
public interface DepartementRepository extends JpaRepository<Departement, Integer>{

	
	
}
