package com.scraps.app.controller;

import com.scraps.app.model.Getting;
import com.scraps.app.model.Logic;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class Controller implements Initializable {
  Getting getting = new Getting();
  Logic logic = new Logic();
  private ExecutorService executorService;

  private boolean optionSelected = false; // Initially set to false
                                          //
  @FXML
  private Button switchButton;

  @FXML
  private TextField nameInput;
  @FXML
  private Label text;
  @FXML
  private VBox errorBox;

  @FXML
  private AnchorPane pane;
  @FXML
  private TextField valueInput;
  @FXML
  private Image myImage;
  @FXML
  private Button submitButton;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    // first put the logic of config screen
    // this.pane.setStyle("-fx-background-image: \"background.jpg\";");
    executorService = Executors.newFixedThreadPool(1);

    // Submit a task to execute getValue() asynchronously
    executorService.submit(this::getValue);
  }

  @FXML
  public void onButtonClick() {
    Label errorMessage = new Label("Coloque um Numero Valido PorFavor");
    errorMessage.setId("errorMessage");

    try {

      float configValue = Float.parseFloat(valueInput.getText());
      if (valueInput.getText().isEmpty() || configValue <= 0.0) {
        errorBox.getChildren().add(errorMessage);
      } else {
        errorBox.getChildren().clear();
        System.out.println("Hello output" + nameInput.getText() +
            "second input" +

            switchButton.getText());
        String[] arraySwitch = switchButton.getText().split(" ");
        System.out.println(arraySwitch[1]);
        System.out.println(valueInput.getText());
        logic.setLogic(arraySwitch[1]);
        logic.setConfigValue(configValue);
      }
    } catch (NumberFormatException e) {

      errorBox.getChildren().add(errorMessage);
    }
  }

  @FXML
  private void onSelectButtonClick() {
    // Toggle the optionSelected flag
    optionSelected = !optionSelected;

    // Update style class based on the selected option
    if (optionSelected) {
      switchButton.getStyleClass().add("selected");
      switchButton.setText("Vela maior que");
    } else {
      switchButton.getStyleClass().remove("selected");
      switchButton.setText("Vela menor que");
    }
  }

  private void getValue() {
    float[] value;
    while (true) {
      value = getting.getValues();
      if (logic.getPrevious() != value[0]) {
        System.out.println("value 1: " + value[0] + "value 2:" + value[1]);
        // if getPrevious != value setIdAndValue
        // change the logic to the config of taller and smaller candles
        logic.setValue(value[1]);
        String[] returnedValue = new String[2];
        returnedValue = logic.compute();
        if (returnedValue != null) {
          if (returnedValue[0] == "true") {
            // call the function to popup
          }
          // set the text to the box of values in sequence returnValue[1]
        }
        logic.setPrevious(value[0]);
      }
      try {
        // Sleep for 10 second
        TimeUnit.SECONDS.sleep(10);
      } catch (InterruptedException e) {
        // Handle InterruptedException
        e.printStackTrace();
      }
    }
  }
}
