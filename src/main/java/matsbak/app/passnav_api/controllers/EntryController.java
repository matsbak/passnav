package matsbak.app.passnav_api.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import matsbak.app.passnav_api.entities.Entry;
import matsbak.app.passnav_api.services.EntryService;

/**
 * The EntryController class represents the REST controller for entries.
 * 
 * <p>All HTTP requests are handeled in this class.</p>
 * 
 * @author Mats Bakketeig
 * @version v1.0 (2024.02.04)
 */
@CrossOrigin
@RestController
@RequestMapping("/api")
public class EntryController {

  @Autowired
  private EntryService entryService;

  private final Logger logger = LoggerFactory.getLogger(EntryController.class);

  /**
   * Returns all entries. When this endpoint is requested, a HTTP 200 OK response is automatically
   * sent back.
   * 
   * @return 200 OK + all entry data
   */
  @Operation(
    summary = "Get all entries",
    description = "Gets all entries"
  )
  @ApiResponses(value = {
    @ApiResponse(
      responseCode = "200",
      description = "All entry data"
    )
  })
  @GetMapping
  public Iterable<Entry> getAll() {
    Iterable<Entry> entries = this.entryService.getAll();
    logger.info("Sending all entry data...");
    return entries;
  }

  /**
   * Returns a HTTP reponse to the request requesting to get the entity with the specified name.
   * 
   * <p>The reponse body contains entry data on success or an error message on error.</p>
   * 
   * @param name The specified name
   * @return <p>200 OK on success + entry data</p>
   *         <p>404 NOT FOUND if entry is not found</p>
   */
  @Operation(
    summary = "Get entry by name",
    description = "Gets the entry with the specified name"
  )
  @ApiResponses(value = {
    @ApiResponse(
      responseCode = "200",
      description = "Entry data"
    ),
    @ApiResponse(
      responseCode = "404",
      description = "Error message"
    )
  })
  @GetMapping("/{name}")
  public ResponseEntity<?> get(
    @Parameter(description = "Name of the entry to get")
    @PathVariable String name
  ) {
    ResponseEntity<?> response;
    Optional<Entry> entry = this.entryService.getByName(name);
    if (entry.isPresent()) {
      logger.info("Entry found, sending entry data...");
      response = new ResponseEntity<>(entry, HttpStatus.OK);
    } else {
      logger.error("Car not found, sending error message...");
      response = new ResponseEntity<>("Entry with specified name not found", HttpStatus.NOT_FOUND);
    }
    return response;
  }
}
