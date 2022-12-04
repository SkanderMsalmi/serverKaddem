package tn.esprit.persistance.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity 
public class Matiere {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idMatiere")
	private Integer idMatiere; 
	private String nomMatiere;
	private String code; 
	
	
	

}
