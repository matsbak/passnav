package matsbak.app.passnav_api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import matsbak.app.passnav_api.entities.Entry;
import matsbak.app.passnav_api.repositories.EntryRepository;

/**
 * The EntryService class represents the service class for the Entry entity.
 * 
 * @author Mats Bakketeig
 * @version v1.0 (2024.04.02)
 */
@Service
public class EntryService {
  @Autowired
  private EntryRepository entryRepository;

  /**
   * Returns all entries in the database.
   * 
   * @return All entries
   */
  public Iterable<Entry> getAll() {
    return this.entryRepository.findAll();
  }

  /**
   * Returns the entry with the specified name in the database, regardless of if it exists or not.
   * 
   * @param name The specified name
   * @return The entry with the specified name
   */
  public Optional<Entry> getByName(String name) {
    return this.entryRepository.findById(name);
  }

  /**
   * Adds the specified entity to the database.
   * 
   * @param entry The specified entry
   * @throws IllegalArgumentException If the specified entry is invalid
   */
  public void add(Entry entry) {
    if (!entry.isValid()) {
      throw new IllegalArgumentException("Entry is invalid");
    }
    this.entryRepository.save(entry);
  }

  /**
   * Returns true if the entry with the specified name is found and deleted or false otherwise.
   * 
   * @param name The specified name
   * @return True if the entry with the specified name is found and deleted or false otherwise
   */
  public boolean delete(String name) {
    Optional<Entry> entry = this.entryRepository.findById(name);
    if (entry.isPresent()) {
      this.entryRepository.deleteById(name);
    }
    return entry.isPresent();
  }
}
