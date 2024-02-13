package com.scraps.app;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TxtWriter {
  private String filePath;

  public TxtWriter(String filePath) { this.filePath = filePath; }

  public void writeData(String data) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(filePath, true))) {
      writer.println(data);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
