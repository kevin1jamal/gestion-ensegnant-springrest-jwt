package org.isj.gestionenseignant.api.service;

import java.util.List;

import org.isj.gestionenseignant.api.domaine.entities.Enseignant;

public interface IService {

	public Enseignant saveEnseignantService(Enseignant enseignant);
	public List<Enseignant> getAllEnseignantService();
	public Enseignant findEnseignantByTelephone(String telephone);

}
