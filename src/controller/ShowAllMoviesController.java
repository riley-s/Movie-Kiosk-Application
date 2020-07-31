
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

public class ShowAllMoviesController extends Controller<Catalogue> {
    @FXML private TableView<Movie> moviesTv;
    
    public Catalogue getCatalogue() { return model; }
    
    @FXML public void initialize() {
        moviesTv.setItems(model.getAllMovies());
        model.getAvailableMovies().addListener((ListChangeListener<Movie>)(c -> {
            moviesTv.setItems(model.getAllMovies());
        }));
    }
    
    public void handleExit(ActionEvent event) {
        stage.close();
    }
}
