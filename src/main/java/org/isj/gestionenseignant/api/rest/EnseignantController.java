package org.isj.gestionenseignant.api.rest;

import java.util.List;

import org.isj.gestionenseignant.api.domaine.dto.EnseignantDto;
import org.isj.gestionenseignant.api.domaine.entities.Enseignant;
import org.isj.gestionenseignant.api.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.Lists;

import io.swagger.annotations.Api;


@RestController
@RequestMapping("/gestionenseignant/api")
@Api(tags = "enseignants")
public class EnseignantController {

	@Autowired
	private IService service;

	@RequestMapping(value="/enseignants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<EnseignantDto> getAllEnseignants() {

		final List<Enseignant> enseignants = service.getAllEnseignantService();

		final List<EnseignantDto> dtos=Lists.transform(enseignants, (Enseignant input) -> new EnseignantDto(input.getNom(),input.getUe(),input.getTelephone(),input.getUrlImage()));

		return dtos;
	}

	@RequestMapping(value = "/creer", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public EnseignantDto saveEnseignant(@RequestBody EnseignantDto enseignantDto) {

		Enseignant enseignant = new Enseignant();
		enseignant.setNom(enseignantDto.getNom());
		enseignant.setUe(enseignantDto.getUe());
		enseignant.setTelephone(enseignantDto.getTelephone());
		enseignant.setUrlImage(enseignantDto.getUrlImage());

		enseignant= service.saveEnseignantService(enseignant);

		return new EnseignantDto(enseignant.getNom(), enseignant.getUe(), enseignant.getTelephone(), enseignant.getUrlImage());
	}

	@RequestMapping(value = "/enseignant/{telephone}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
	public EnseignantDto getEnseignantByTelephone(@PathVariable String telephone) {

		final Enseignant enseignant= service.findEnseignantByTelephone(telephone);

		return new EnseignantDto(enseignant.getNom(), enseignant.getUe(), enseignant.getTelephone(), enseignant.getUrlImage());
	}

}
