
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

public class RemoveCustomerController extends Controller<Kiosk> {
    @FXML TableView<Customer> customersTv;
    @FXML private Button removeBtn;
    
    public Kiosk getKiosk() { return model; }
    
    @FXML public void initialize() {
        removeBtn.disableProperty().bind(customersTv.getSelectionModel().selectedItemProperty().isNull());
    }
    public void removeCustomer(ActionEvent event) {
        model.removeCustomer(customersTv.getSelectionModel().getSelectedItem());
    }
    public void handleExit(ActionEvent event) {
        stage.close();
    }

}
