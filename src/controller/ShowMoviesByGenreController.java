
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
import javafx.scene.layout.*;


public class ShowMoviesByGenreController extends Controller<Catalogue> {
    @FXML private ListView<Genre> genresLv;
    @FXML private TableView<Movie> moviesTv;
    @FXML private Button displayBtn;
    @FXML private VBox movieTableVb;
    
    public Catalogue getCatalogue() { return model; }
    
    @FXML public void initialize() {
        displayBtn.disableProperty().bind(genresLv.getSelectionModel().selectedItemProperty().isNull());
        HBox.setHgrow(movieTableVb, Priority.ALWAYS);
    }
    
    public void loadMovies(ActionEvent event) {	
        moviesTv.setItems(model.getMoviesInGenre(genresLv.getSelectionModel().getSelectedItem()));
    }
    
    public void handleExit(ActionEvent event) {
        stage.close();
    }
}
