
package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.binding.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import model.*;
import au.edu.uts.ap.javafx.*;
import javafx.application.Platform;

public class KioskController extends Controller<Kiosk> {
  public final Kiosk getKiosk() { return model; }
    
  @FXML public void initialize() {
  
  }

  public void adminMenu(ActionEvent event) throws IOException {
      ViewLoader.showStage(model, "/view/Admin.fxml", "Administration Menu", new Stage());
  }
  public void showCatalogue(ActionEvent event) throws IOException {
      ViewLoader.showStage(model.getCatalogue(), "/view/Catalogue.fxml", "Catalogue", new Stage());
  }
  public void customerRecord(ActionEvent event) throws IOException {
      ViewLoader.showStage(model, "/view/CustomerRecord.fxml", "Patron Record", new Stage());
  }
  public void topUpAccount(ActionEvent event) throws IOException {
      ViewLoader.showStage(model, "/view/TopUpAccount.fxml", "Account Top-up", new Stage());
  }
  public void favouriteMovies(ActionEvent event) throws IOException {
      ViewLoader.showStage(model, "/view/FavouriteMovies.fxml", "Favourites", new Stage());
  }
  public void handleQuit(ActionEvent event) {
      Platform.exit();
  }

}

