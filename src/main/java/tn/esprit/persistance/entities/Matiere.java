package tn.esprit.persistance.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Matiere {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idMatiere")
	private Integer idMatiere; 
	private String nomMatiere;
	private String code; 
	
	

}
