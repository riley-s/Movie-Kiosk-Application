
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

public class ReturnMovieController extends Controller<Catalogue> {
    @FXML private TextField idTf;
    @FXML private Button idBtn;
    @FXML private TableView<Movie> moviesTv;
    @FXML private Text feedbackTxt;
    @FXML private Button returnBtn;
    
    private Customer customer;
    
    public Catalogue getCatalogue() { return model; }
    
    @FXML public void initialize() {
        idBtn.disableProperty().bind((idTf.lengthProperty()).isEqualTo(0));
        returnBtn.disableProperty().bind(moviesTv.getSelectionModel().selectedItemProperty().isNull());
    }
    
    public void loadMovies(ActionEvent event) {
        try {
            customer = model.getCustomer(Integer.parseInt(idTf.getText()));
            if (customer != null) {
                moviesTv.setItems(customer.currentlyRented());
            } else {
                feedbackTxt.setText("ID does not exist.");
                moviesTv.setItems(null);
            }
        } catch (Exception e) {
            feedbackTxt.setText("Invalid ID.");
            moviesTv.setItems(null);
        }
    }
    
    public void returnMovie(ActionEvent event) {
        model.returnMovieFromCustomer(moviesTv.getSelectionModel().getSelectedItem(), customer);
        feedbackTxt.setText("Movie Returned.");
    }
    
    public void handleExit(ActionEvent event) {
        stage.close();
    }
}
