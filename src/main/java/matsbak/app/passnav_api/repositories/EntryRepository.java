package matsbak.app.passnav_api.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import matsbak.app.passnav_api.entities.Entry;

/**
 * The EntryRepository class represents the repository class for the Entry entity.
 * 
 * @author Mats Bakketeig
 * @version v0.0.1 (2024.04.02)
 */
@Repository
public interface EntryRepository extends CrudRepository<Entry, String> {}
