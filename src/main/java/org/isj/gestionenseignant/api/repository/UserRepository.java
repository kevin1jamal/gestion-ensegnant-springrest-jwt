package org.isj.gestionenseignant.api.repository;

import javax.transaction.Transactional;

import org.isj.gestionenseignant.api.domaine.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

	boolean existsByUsername(String username);

	User findByUsername(String username);

	@Transactional
	void deleteByUsername(String username);

}
