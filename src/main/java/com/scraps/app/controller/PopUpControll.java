package com.scraps.app.controller;

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;

public class PopUpControll implements Initializable {

  public static String valueShow;
  @FXML
  private TextField popUpText;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    showText();
  }

  private void showText() {
    popUpText.setText(this.valueShow);
  }
}
