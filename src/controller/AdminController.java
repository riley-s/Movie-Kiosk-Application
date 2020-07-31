
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

public class AdminController extends Controller<Kiosk> {
    public Kiosk getKiosk() { return model; }
    
    @FXML void initialize() {
        
    }
    
    public void showAllCustomer(ActionEvent event) throws IOException {
        ViewLoader.showStage(model, "/view/ShowAllCustomers.fxml", "Show All Customers", new Stage());
    }
    public void addCustomer(ActionEvent event) throws IOException {
        ViewLoader.showStage(model, "/view/AddCustomer.fxml", "Add Customer", new Stage());
    }
    public void removeCustomer(ActionEvent event) throws IOException {
        ViewLoader.showStage(model, "/view/RemoveCustomer.fxml", "Remove Customer", new Stage());
    }
    public void showAllMovies(ActionEvent event) throws IOException {
        ViewLoader.showStage(model.getCatalogue(), "/view/ShowAllMovies.fxml", "Show All Movies", new Stage());
    }
    public void addMovie(ActionEvent event) throws IOException {
        ViewLoader.showStage(model.getCatalogue(), "/view/AddMovie.fxml", "Add Movie", new Stage());
    }
    public void removeMovie(ActionEvent event) throws IOException {
        ViewLoader.showStage(model.getCatalogue(), "/view/RemoveMovie.fxml", "Remove Movie", new Stage());
    }
    public void handleExit(ActionEvent event) {
        stage.close();
    }
    
}
