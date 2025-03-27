package matsbak.app.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Storage class represents a storage of {@link Entry entries}. The entries are stored in a
 * list that composes all passwords stored in the application.
 */
public class Storage {
  private List<Entry> entries;

  /**
   * Constructor for Storage.
   */
  public Storage() {
    this.setEntries(new ArrayList<>());
  }

  /**
   * Getter for entries.
   * 
   * @return Entries
   */
  public List<Entry> getEntries() {
    return this.entries;
  }

  /**
   * Setter for entries.
   * 
   * @param entries The specified entries
   */
  public void setEntries(List<Entry> entries) {
    this.entries = entries;
  }
}
