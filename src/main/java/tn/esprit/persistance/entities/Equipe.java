package tn.esprit.persistance.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import tn.esprit.persistance.enumartion.Niveau;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Equipe")
public class Equipe implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEquipe;
	private String nomEquipe;
	@Enumerated(EnumType.STRING)
	private Niveau niveau;
	
	@JsonIgnore
	@OneToOne
	private DetailEquipe detailEquipe;
	
	@JsonIgnore
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Etudiant> etudiants;
}
