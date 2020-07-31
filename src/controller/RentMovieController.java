
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

public class RentMovieController extends Controller<Catalogue> {
    @FXML private TextField idTf;
    @FXML private Button idBtn;
    @FXML private TableView<Movie> moviesTv;
    @FXML private Button rentBtn;
    @FXML private Text feedbackTxt;
    private Customer customer;

    public Catalogue getCatalogue() { return model; }
    
    @FXML public void initialize() {
        idBtn.disableProperty().bind(idTf.textProperty().isEmpty());
        rentBtn.disableProperty().bind(moviesTv.getSelectionModel().selectedItemProperty().isNull());
    }
    
    public void setCustomer(ActionEvent event) {
        try {
            customer = model.getCustomer(Integer.parseInt(idTf.getText()));
            if (customer != null) {
                moviesTv.setItems(model.getAvailableMovies());
            } else {
                feedbackTxt.setText("ID does not exist.");
                moviesTv.setItems(null);
            }
        } catch (Exception e) {
            feedbackTxt.setText("Invalid ID.");
            moviesTv.setItems(null);
        }
    }
    
    public void rentMovie(ActionEvent event) {
        if (model.rentMovieToCustomer(moviesTv.getSelectionModel().getSelectedItem(), customer)) {
            feedbackTxt.setText("Movie Rented.");
        } else {
            feedbackTxt.setText("Insufficient funds.");
        }
    }
    
    public void handleExit(ActionEvent event) {
        stage.close();
    }

}
