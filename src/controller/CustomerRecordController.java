
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

public class CustomerRecordController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private Button idBtn;
    @FXML private Text customerDetailsTxt;
    @FXML private TableView<Movie> rentedMoviesTv;
    @FXML private TableView<Movie> rentingHistoryTv;
    
    public Kiosk getKiosk() { return model; }
    
    @FXML public void initialize() {
        idBtn.disableProperty().bind(idTf.textProperty().isEmpty());
    }
    
    public void loadMovies(ActionEvent event) {
        try {
            Customer c = model.getCustomer(Integer.parseInt(idTf.getText()));
            if (c != null) {
                customerDetailsTxt.setText(c.toString());
		rentedMoviesTv.setItems(c.currentlyRented());
		rentingHistoryTv.setItems(c.rentingHistory());
		} else {
		customerDetailsTxt.setText("ID does not exist.");
		rentedMoviesTv.setItems(null);
		rentingHistoryTv.setItems(null);
			}
		} catch (Exception e) {
                    customerDetailsTxt.setText("Invalid ID.");
		}
	}
    public void handleExit(ActionEvent event) {
        stage.close();
    }


}
