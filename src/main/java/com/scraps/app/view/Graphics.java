package com.scraps.app.view;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Graphics extends Application {

  @Override
  public void start(Stage primaryStage) throws Exception {
    System.out.println("entrou no start");
    FXMLLoader loader = new FXMLLoader(getClass().getResource(
        "src/main/java/com/scraps/app/view/fxml/index.fxml"));
    System.out.println(loader);

    System.out.println("entrou no start 2");
    // its not catching the fxml file
    URL path = new File("src/main/java/com/scraps/app/view/fxml/index.fxml")
        .toURI()
        .toURL();

    System.out.println(path);
    Parent page = (Parent) FXMLLoader.load(path);
    // AnchorPane page1 = (AnchorPane) loader.load();

    System.out.println("entrou no start 3");
    Scene scene = new Scene(page, 500, 500, Color.BLACK);

    primaryStage.setTitle("StackPane Demo");
    primaryStage.setScene(scene);
    primaryStage.show();
  }
}
