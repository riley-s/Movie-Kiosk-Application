
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

public class CatalogueController extends Controller<Catalogue> {
    public Catalogue getCatalogue() { return model; }
    
    @FXML public void initialize() {
    
    }
    
    public void showAllMovies(ActionEvent event) throws IOException {
	ViewLoader.showStage(model, "/view/ShowAllMovies.fxml", "All Movies", new Stage());
    }
    public void showAvailableMovies(ActionEvent event) throws IOException {
        ViewLoader.showStage(model, "/view/ShowAvailableMovies.fxml", "Available Movies", new Stage());
    }
    public void showMoviesByGenre(ActionEvent event) throws IOException {
	ViewLoader.showStage(model, "/view/ShowMoviesByGenre.fxml", "Movies By Genre", new Stage());
    }
    public void showMoviesByYear(ActionEvent event) throws IOException {
	ViewLoader.showStage(model, "/view/ShowMoviesByYear.fxml", "Movies By Year", new Stage());
    }

    public void rentMovie(ActionEvent event) throws IOException {
	ViewLoader.showStage(model, "/view/RentMovie.fxml", "Rent a Movie", new Stage());
    }
    public void returnMovie(ActionEvent event) throws IOException {
	ViewLoader.showStage(model, "/view/ReturnMovie.fxml", "Return a Movie", new Stage());
    }

    public void handleExit(ActionEvent event) {
	stage.close();
    }

}
