package org.isj.gestionenseignant.api.service;

import java.util.List;

import org.isj.gestionenseignant.api.domaine.entities.Enseignant;
import org.isj.gestionenseignant.api.repository.EnseignantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ServiceImpl implements IService {

	@Autowired
	EnseignantRepository enseignantRepository;


	@Override
	public Enseignant saveEnseignantService(Enseignant enseignant) {


		return enseignantRepository.save(enseignant);
	}

	@Override
	public List<Enseignant> getAllEnseignantService() {
		return enseignantRepository.findAll();
	}

	@Override
	public Enseignant findEnseignantByTelephone(String telephone) {
		return enseignantRepository.findByTelephone(telephone);
	}

}
