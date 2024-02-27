package com.scraps.app.controller;

import com.scraps.app.controller.PopUpControll;
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
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class MonitorControll implements Initializable {
  Getting getting = new Getting();
  Logic logic = new Logic();
  PopUpControll popUpControll = new PopUpControll();
  private ExecutorService executorService;
  public static String logicCandle;
  public static float configValue;
  public static int numberCount;
  @FXML
  private AnchorPane pane;
  @FXML
  private FlowPane flowPane;
  @FXML
  private VBox vBox;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    logic.setLogic(logicCandle);
    logic.setConfigValue(configValue);
    logic.setNumberCount(numberCount);
    callGetValue();
  }

  private void popUpscene(String valueShow) {

    Platform.runLater(() -> {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Notificação");
      alert.setHeaderText("Notificação de Vela");
      alert.setContentText(valueShow); // ww w . j a va2s . co m

      alert.showAndWait();
    });
  }

  private void timer(int time) {
    try {
      // Sleep for 10 second
      TimeUnit.SECONDS.sleep(time);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

  private void callGetValue() {
    System.out.println("get");
    executorService = Executors.newFixedThreadPool(1);
    System.out.println("value");
    executorService.submit(this::getValue);
  }

  @FXML
  public void onButtonClickConfig(ActionEvent event) {
    switchScene(event);
  }

  private void switchScene(ActionEvent event) {
    try {
      URL path = new File("src/main/java/com/scraps/app/view/index.fxml")
          .toURI()
          .toURL();

      Parent page = (Parent) FXMLLoader.load(path);
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      Scene scene = new Scene(page);
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void updateUI(String value) {
    Platform.runLater(() -> {
      Label textBox = new Label(value);
      textBox.getStyleClass().add("box");
      flowPane.getChildren().add(textBox);
    });
  }

  private void getValue() {
    float[] value;
    while (true) {
      value = getting.getValues();
      System.out.println("value: " + value[0]);
      System.out.println("previous: " + logic.getPrevious());
      if (logic.getPrevious() != value[0]) {
        System.out.println("value 1: " + value[0] + "value 2:" + value[1]);
        // if getPrevious != value setIdAndValue
        // change the logic to the config of taller and smaller candles
        logic.setValue(value[1]);
        String[] returnedValue = new String[2];
        returnedValue = logic.compute();
        System.out.println("entrou != null");
        // ret[0] nullret[1] 2.93
        // entrou != null

        if (returnedValue[0].equals("true")) {
          // call the function to popup
          System.out.println("popUp");
          popUpscene(returnedValue[1]);
        }
        // for write to the box
        System.out.println("Before writeValue");
        System.out.println("value to be writed: " + returnedValue[1]);
        updateUI(returnedValue[1]);
      }
      logic.setPrevious(value[0]);
      timer(10);
    }
  }
}
