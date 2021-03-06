
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

public class ShowAvailableMoviesController extends Controller<Catalogue> {
    public Catalogue getCatalogue() { return model; }
    
    @FXML public void initialize() {}
    
    public void handleExit(ActionEvent event) {
        stage.close();
    }
}
