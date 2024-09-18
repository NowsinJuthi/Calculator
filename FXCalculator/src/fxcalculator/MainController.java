/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package fxcalculator;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class MainController implements Initializable {

    @FXML
    private Button deleteButton;
    @FXML
    private Button clearButton;
    
    @FXML
       public void exit(){
    
        System.exit(0);
      }

    @FXML
    private Label label;
    private long num1 = 0;
    private String operator = "";
    private boolean start = true;

    Model model = new Model();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void processNumber(ActionEvent event) {
        if (start) {
            label.setText("");
            start = false;
        }
        String value = ((Button) event.getSource()).getText();
        label.setText(label.getText() + value);

    }

    @FXML
    private void processOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();
        if (!value.equals("=")) {
            if (!operator.isEmpty()) {
                return;
            }
            operator = value;
            num1 = Long.parseLong(label.getText());
            label.setText("");
        } else {
            if (operator.isEmpty()) {
                return;
            }
            long num2 = Long.parseLong(label.getText());
            float output = model.calculate(num1, num2, operator);
            label.setText(String.valueOf(output));
        }
    }
    @FXML
    private void handleDeleteAction(ActionEvent event) {
        String currentText = label.getText();
       
        if (!currentText.isEmpty()) {
           
            label.setText(currentText.substring(0, currentText.length() - 1));
        }
    }
    @FXML
    private void handleClearAction(ActionEvent event) {
        label.setText("");
        start = true;
    }
    @FXML
    private void calculateSquare(ActionEvent event) {
        
         try {
            double number = Double.parseDouble(label.getText());
            double square = Math.pow(number, 2);
            label.setText("" + square);
        } catch (NumberFormatException e) {}
    }
    @FXML
    private void calculateCube(ActionEvent event) {
        try {
            
            double number = Double.parseDouble(label.getText());

            double cube = Math.pow(number, 3);
     
            label.setText("" + cube);
        } catch (NumberFormatException e) {}
  }
}
