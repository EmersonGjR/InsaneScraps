package com.scraps.app.controller;

import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
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

    File pathCss = new File("src/main/java/com/scraps/app/styles/style.css");
    // .toURL();

    System.out.println(path);
    Parent page = (Parent) FXMLLoader.load(path);
    // AnchorPane page1 = (AnchorPane) loader.load();
    System.out.println(getClass().getResource("style.css"));
    System.out.println("entrou no start 3");
    Scene scene = new Scene(page, 500, 500);
    primaryStage.setTitle("StackPane Demo");
    // scene.getStylesheets().add("src/main/java/com/scraps/app/styles/style.css");
    // getClass().getResource("/controller/style.css").toExternalForm());
    primaryStage.setScene(scene);

    primaryStage.show();
  }
}
