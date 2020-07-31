
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

public class TopUpAccountController extends Controller<Kiosk> {
    @FXML private TextField idTf;
    @FXML private TextField amountTf;
    @FXML private Text feedbackTxt;
    @FXML private Button topUpBtn;

    public Kiosk getKiosk() { return model; }
    
    @FXML public void initialize() {
        topUpBtn.disableProperty().bind(Bindings.or(idTf.textProperty().isEmpty(), amountTf.textProperty().isEmpty()));
    }
    
    public void topUp(ActionEvent event) {
        try {
            Customer c = model.getCustomer(Integer.parseInt(idTf.getText()));
            if (c != null) {
                model.topUpAccount(c, Integer.parseInt(amountTf.getText()));
                feedbackTxt.setText("Transaction Complete.");
            } else {
                feedbackTxt.setText("ID does not exist.");
            }
        } catch (Exception e) {
            feedbackTxt.setText("ID and Amount must be numeric.");
        }
    }
    
    public void handleExit(ActionEvent event) {
        stage.close();
    }
}