package tn.esprit.persistance.entities;

import java.io.Serializable;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Departement implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idDepartement")
	private Integer idDepartement; 
	private String nomDepart;
	private String codeInterne; 
	private String chefDepart;
	private String emailDepart;   
	private String bloc;
	
	

    
	@OneToMany(mappedBy = "departement")
	private Set<Etudiant> Etudiants;




	@Override
	public String toString() {
		return "Departement [idDepartement=" + idDepartement + ", nomDepart=" + nomDepart + ", codeInterne="
				+ codeInterne + ", chefDepart=" + chefDepart + ", emailDepart=" + emailDepart + ", bloc=" + bloc + "]";
	}






}