package tn.esprit.persistance.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Enseignant implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEnseignant")
	private Integer idEnseignant;
	private String codeEns;
	private String nom;
	private String prenom;
	private String image;
	private String role;
	private String email;
	
	
	
	@JsonIgnore
	@ManyToOne
	private Departement departement;



	@Override
	public String toString() {
		return "Enseignant [idEnseignant=" + idEnseignant + ", codeEns=" + codeEns + ", nom=" + nom + ", prenom="
				+ prenom + ", image=" + image + ", role=" + role + ", email=" + email + "]";
	}
	
	
	
	
	

	
	
	
	

	

}
