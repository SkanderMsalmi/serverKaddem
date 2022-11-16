package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.persistance.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Integer>{

}
