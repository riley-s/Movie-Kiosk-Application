
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

public class FavouriteMoviesController extends Controller<Kiosk> {
    @FXML TextField idTf;
    @FXML TableView<Movie> moviesTv;
    @FXML Button idBtn;
    @FXML Text feedbackTxt;
    
    public Kiosk getKiosk() { return model; }
    
    @FXML public void initialize() {
        idBtn.disableProperty().bind(idTf.textProperty().isEmpty());
    }
    
    public void loadMovies(ActionEvent event) {
        try {
            Customer c = model.getCustomer(Integer.parseInt(idTf.getText()));
            if (c != null) {
                moviesTv.setItems(c.favouriteMovies());
            } else {
                feedbackTxt.setText("ID does not exist.");
                moviesTv.setItems(null);
            }
        } catch (Exception e) {
            feedbackTxt.setText("Invalid ID.");
            moviesTv.setItems(null);
        }
    }
    
    public void handleExit(ActionEvent event) {
        stage.close();
    } 
}
