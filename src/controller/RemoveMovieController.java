
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

public class RemoveMovieController extends Controller<Catalogue> {
    @FXML private TableView<Movie> moviesTv;
    @FXML private Button removeBtn;
	
    public Catalogue getCatalogue() { return model; }
    
    @FXML public void initialize() {
        removeBtn.disableProperty().bind(moviesTv.getSelectionModel().selectedItemProperty().isNull());
    }
    public void removeMovie(ActionEvent event) {
        model.removeMovie(moviesTv.getSelectionModel().getSelectedItem());
    }
    public void handleExit(ActionEvent event) {
        stage.close();
    }

}
