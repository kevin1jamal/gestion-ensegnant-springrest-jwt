package org.isj.gestionenseignant.api.domaine.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "enseignant")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Enseignant {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idEns;

	private String nom;
	private String ue;
	private String telephone;
	private String urlImage;


}
