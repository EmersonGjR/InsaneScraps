package com.scraps.app;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.*;
import jxl.write.DateTime;
import jxl.write.Number;

public class ExcelWriter {
  private int row = 1;
  private float value;
  private boolean isOpen = false;
  private boolean isCreated = false;
  private WritableWorkbook workbook;
  private String filePath = "output.xlsx";
  private WritableSheet sheet;

  public ExcelWriter() { openCreate(); }

  public void openCreate() {
    try {

      this.workbook = Workbook.createWorkbook(new File(filePath));
      this.sheet = this.workbook.createSheet("crash", 0);
      Label label1 = new Label(0, 0, "Time");
      this.sheet.addCell(label1);
      Label label2 = new Label(1, 0, "Crash Values");
      this.sheet.addCell(label2);

    } catch (IOException | WriteException e) {
      System.out.println("exception create");
      e.printStackTrace();
    }
  }

  public void open() {

    try { // Open or create the workbook at the specified file path

      System.out.println("beggin of open");
      Workbook workbook1 = Workbook.getWorkbook(new File(filePath));
      this.workbook = Workbook.createWorkbook(new File(filePath), workbook1);
      // Get the first sheet in the workbook (assuming there's only one)
      this.sheet = this.workbook.getSheet(0);
      this.isOpen = true;
      workbook.close();

      System.out.println("finish of open");
    } catch (WriteException | IOException e) {

      System.out.println("exception open");
      e.printStackTrace();
    }

    System.out.println("open");
  }
  public void write() {
    if (!isOpen) {
      open();
    }
    try {
      // Add data to the sheet
      // Number idCell = new Number(0, this.row, this.id);
      // this.sheet.addCell(idCell);
      // maybe i have to open datasheet and get the next value and do
      // last+this.row
      System.out.println("im writing first");
      System.out.println("im writing");
      DateTime timeCell =
          new DateTime(0, (1 + this.sheet.getRows()), new java.util.Date());
      this.sheet.addCell(timeCell);
      Number valueCell = new Number(1, (1 + this.sheet.getRows()), this.value);
      this.sheet.addCell(valueCell);
      save();
      // Increment row for next data
      this.row++;

    } catch (WriteException e) {

      System.out.println("exception write");
      e.printStackTrace();
    }
  }

  public void setValue(float value) {
    this.value = value;
    System.out.println("setvalue");
  }

  public void save() {
    if (isOpen) {
      try {
        System.out.println("im saving");
        this.workbook.write();
      } catch (IOException e) {
        System.out.println("exception write");
        e.printStackTrace();
      } finally {
        try {
          if (workbook != null) {
            System.out.println("closing");
            this.isOpen = false;
            this.workbook.close();
          }
        } catch (IOException | WriteException e) {

          System.out.println("exception close");
          e.printStackTrace();
        }
      }
    }
  }
}
