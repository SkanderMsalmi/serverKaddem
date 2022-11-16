package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.persistance.entities.Contrat;

public interface ContratRepository extends JpaRepository<Contrat, Integer>{

}
