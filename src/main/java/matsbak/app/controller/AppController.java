package matsbak.app.controller;

import matsbak.app.view.AppView;

/**
 * The AppController class represents main controller class of the application. In this class, all
 * models and the main view are controlled, along with the interactions between them.
 * 
 * @author Mats Bakketeig
 * @version v0.0.1-SNAPSHOT (2025.03.27)
 */
public class AppController {
  private AppView appView;

  public AppController() {
    this.appView = new AppView();
  }

  public void launch() {
    appView.start();
  }
}
