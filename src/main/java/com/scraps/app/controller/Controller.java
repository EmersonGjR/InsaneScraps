package com.scraps.app.controller;

import com.scraps.app.controller.MonitorControll;
import com.scraps.app.model.Getting;
import com.scraps.app.model.Logic;
import java.io.File;
import java.io.IOError;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller implements Initializable {
  private boolean optionSelected = false; // Initially set to menor
  @FXML
  private Button switchButton;

  @FXML
  private TextField nameInput;
  @FXML
  private Label text;
  @FXML
  private VBox errorBox;
  @FXML
  private TextField numberInput;
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
  }

  @FXML
  public void onButtonClick(ActionEvent event) {
    Label errorMessage = new Label("Coloque um Numero Valido PorFavor");
    errorMessage.setId("errorMessage");

    try {

      float configValue = Float.parseFloat(valueInput.getText());
      int numberCount = Integer.parseInt(numberInput.getText());
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

        switchScene(event, arraySwitch[1], configValue, numberCount);
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

  private void switchScene(ActionEvent event, String logicCandle,
      float configValue, int numberCount) {
    try {
      URL path = new File("src/main/java/com/scraps/app/view/monitor.fxml")
          .toURI()
          .toURL();

      MonitorControll monitorControll = new MonitorControll();
      monitorControll.logicCandle = logicCandle;
      monitorControll.configValue = configValue;
      monitorControll.numberCount = numberCount;

      Parent page = (Parent) FXMLLoader.load(path);
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      Scene scene = new Scene(page);
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
