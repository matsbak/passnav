package matsbak.app.passnav_api.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 * The Entry entity class represents the entity where a password is stored.
 * 
 * <p>The class uses JPA annotations for ORM operations.</p>
 * 
 * @author Mats Bakketeig
 * @version v1.0 (2024.02.04)
 */
@Entity(name = "entry")
@Schema(description = "An entry entity, representing a specific entry in the list")
public class Entry {

  @Id
  @Schema(description = "Entry name")
  private String name;

  @Schema(description = "Stored password")
  private String password;

  /**
   * Constructs an instance of the Entry class.
   * 
   * <p>Empty constructor required by the framework.</p>
   */
  public Entry() {
    // Intentionally left blank
  }

  /**
   * Constructs an instance of the Entry class.
   * 
   * @param name The specified name
   * @param password The specified password
   */
  public Entry(String name, String password) {
    this.name = name;
    this.password = password;
  }

  public String getName() {
    return this.name;
  }

  public String getPassword() {
    return this.password;
  }

  /**
   * Returns true if the entry is valid or false otherwise.
   * 
   * @return True if entry is valid or false otherwise
   */
  public boolean isValid() {
    return !this.name.isBlank() && this.name != null;
  }
}
