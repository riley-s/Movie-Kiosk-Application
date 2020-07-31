
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

public class AddCustomerController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private TextField nameTf;
    @FXML private TextField balanceTf;
    @FXML private Text feedbackTxt;
    @FXML private Button addBtn;
    
    public final Kiosk getKiosk() { return model; }
    
    @FXML public void initialize() {
        addBtn.disableProperty()
                    .bind(Bindings.or(idTf.textProperty().isEmpty(),
			Bindings.or(nameTf.textProperty().isEmpty(), balanceTf.textProperty().isEmpty())));
    }
    
    public void addCustomer(ActionEvent event) {
        try {
            int idCheck = Integer.parseInt(idTf.getText());
            if (model.getCustomer(idCheck) == null) {
                model.addCustomer(idCheck, nameTf.getText(), Integer.parseInt(balanceTf.getText()));
                feedbackTxt.setText("Customer added to Kiosk.");
            }
            else {
                feedbackTxt.setText("ID already in use.");
            }
        } catch (Exception e) {
            feedbackTxt.setText("ID and Balance must be numeric.");
        }
    }
    
    public void handleExit(ActionEvent event) {
        stage.close();
    }

}
