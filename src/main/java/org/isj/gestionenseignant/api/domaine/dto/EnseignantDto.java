package org.isj.gestionenseignant.api.domaine.dto;

import java.io.Serializable;

public class EnseignantDto implements Serializable {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String nom;
	private String ue;
	private String telephone;
	private String urlImage;

	public EnseignantDto() {
		super();
	}

	public EnseignantDto(String nom, String ue, String telephone, String urlImage) {
		super();
		this.nom = nom;
		this.ue = ue;
		this.telephone = telephone;
		this.urlImage = urlImage;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUe() {
		return ue;
	}

	public void setUe(String ue) {
		this.ue = ue;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}



	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@Override
	public String toString() {
		return "Enseignant [ nom=" + nom + ", ue=" + ue + ", telephone=" + telephone + "]";
	}


}
