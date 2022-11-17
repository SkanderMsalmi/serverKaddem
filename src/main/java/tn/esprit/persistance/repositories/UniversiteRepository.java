package tn.esprit.persistance.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.persistance.entities.Universite;

public interface UniversiteRepository extends JpaRepository<Universite, Integer> {

}
