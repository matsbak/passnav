package matsbak.app;

import matsbak.app.controller.AppController;

/**
 * The PassnavApp class represents the runner class of the application.
 * 
 * @author Mats Bakketeig
 * @version v0.0.1 (2025.03.27)
 */
public class PassnavApp {
  public static void main(String[] args) {
    AppController appController = new AppController();
    appController.launch();
  }
}
