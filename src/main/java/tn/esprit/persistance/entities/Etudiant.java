package tn.esprit.persistance.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.persistance.enumartion.Option;

@Entity
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Etudiant")
public class Etudiant implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idEtudiant")
	private Integer idEtudiant;
	private String prenomE;
	private String nomE;
	@Enumerated(EnumType.STRING)
	private Option opt;
	
	@JsonIgnore
	@OneToMany(cascade= CascadeType.ALL ,mappedBy = "etudiant")
	private Set<Contrat> contrat;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "etudiants",cascade = CascadeType.ALL)
	private Set<Equipe> equipes;
	
	@JsonIgnore
	@ManyToOne
	private Departement departement;
	
}
