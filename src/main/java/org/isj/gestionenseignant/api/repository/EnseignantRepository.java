/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.isj.gestionenseignant.api.repository;


import java.util.List;

import org.isj.gestionenseignant.api.domaine.entities.Enseignant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


/**
 *
 * @author fouomene
 */
public interface EnseignantRepository extends JpaRepository<Enseignant, Long>{

	Enseignant findByTelephone(String telephone);

	List<Enseignant> findByNom(String nom);

	List<Enseignant> findByUeLike(String ue);

	List<Enseignant> findTop3ByOrderByIdEnsAsc();

	@Query("SELECT e FROM Enseignant e WHERE e.ue = :ue ORDER BY e.idEns DESC")
	List<Enseignant> findEnseignantByUe(@Param("ue") String ue);


}
