package matsbak.app.model;

/**
 * The Entry class represents an entry in the {@link Storage storage}. An entry consists of a
 * password and a label that describes its usage area.
 * 
 * @author Mats Bakketeig
 * @version v0.0.1 (2025.03.27)
 */
public class Entry {
  private String label;
  private String password;

  /**
   * Constructor for Entry class.
   * 
   * @param label The specified label
   * @param password The specified password
   */
  public Entry(String label, String password) {
    this.setLabel(label);
    this.setPassword(password);
  }

  /**
   * Getter for label.
   * 
   * @return Label
   */
  public String getLabel() {
    return this.label;
  }

  /**
   * Setter for label.
   * 
   * @param label The specified label
   * @throws IllegalArgumentException If the specified label is null or blank
   */
  public void setLabel(String label) {
    if (label == null || label.isBlank()) {
      throw new IllegalArgumentException("The specified label cannot be null or blank");
    }
    this.label = label;
  }

  /**
   * Getter for password.
   * 
   * @return Password
   */
  public String getPassword() {
    return this.password;
  }

  /**
   * Setter for password.
   * 
   * @param password The specified password
   * @throws IllegalArgumentException If the specified password is null or blank
   */
  public void setPassword(String password) {
    if (label == null || label.isBlank()) {
      throw new IllegalArgumentException("The specified password cannot be null or empty");
    }
    this.password = password;
  }
}
