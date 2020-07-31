
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

public class AddMovieController extends Controller<Catalogue> {
    @FXML private TextField titleTf;
    @FXML private TextField yearTf;
    @FXML private TextField genreTf;
    @FXML private TextField priceTf;
    @FXML private Text feedbackTxt;
    @FXML private Button addBtn;
    
    public Catalogue getCatalogue() { return model; }
    
    @FXML public void initialize() {
        addBtn.disableProperty()
			.bind(Bindings.or(titleTf.textProperty().isEmpty(), Bindings.or(yearTf.textProperty().isEmpty(),
						Bindings.or(genreTf.textProperty().isEmpty(), priceTf.textProperty().isEmpty()))));
   }
    
    public void addMovie(ActionEvent event) {
        try {
            model.addMovie(titleTf.getText(), Integer.parseInt(yearTf.getText()), genreTf.getText(),
					Integer.parseInt(priceTf.getText()));
			feedbackTxt.setText("Movie added to Catalogue.");
        } catch (Exception e) {
            feedbackTxt.setText("Year and Price must be numeric.");
        }
    }
    
    public void handleExit(ActionEvent event) {
        stage.close();
    }
    
}
