package com.scraps.app.controller;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {
  // value 0 always gonna be the id, and value 1 gonna be the value of crash
  //
  public static void main(String[] args) {
    // Application.launch(com.scraps.app.view.Graphics.class, args);
    launch(args);
    System.out.println("here");
    // Getting getting = new Getting();
    // Logic logic = new Logic();
  }

  @Override
  public void start(Stage primaryStage) throws Exception {
    System.out.println("entrou no start");
    FXMLLoader loader = new FXMLLoader(getClass().getResource(
        "src/main/java/com/scraps/app/view/fxml/index.fxml"));
    System.out.println(loader);

    System.out.println("entrou no start 2");

    URL path = new File("src/main/java/com/scraps/app/view/index.fxml")
        .toURI()
        .toURL();

    Parent page = (Parent) FXMLLoader.load(path);
    Scene scene = new Scene(page);
    primaryStage.setTitle("StackPane Demo");
    primaryStage.setScene(scene);

    primaryStage.show();
  }
}
