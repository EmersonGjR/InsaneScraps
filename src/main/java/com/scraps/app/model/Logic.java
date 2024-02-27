package com.scraps.app.model;

/**
 * Hello world!
 *
 */

public class Logic {
  // string to know if its taller or smaller the logic
  String logic;
  // value comming from the crash
  float value;
  // value comming from the config to put as the stoped
  float configValue;
  float previous;
  int numberCount;
  int count = 0;

  // PopUp popUp = new PopUp();
  public Logic() {
    // set to init the graphic
    // popUp.init();
  }

  public String[] compute() {
    System.out.println("entrou compute");
    String[] returnValue = new String[2];
    String stringValue = String.valueOf(this.value);
    System.out.println("this.logic " + this.logic);
    System.out.println("this.value " + this.value);
    if (this.logic != null) {
      System.out.println("entrou != null");
      if (this.logic.equals("menor")) {
        System.out.println("menor");
        if (this.value < this.configValue) {
          if (this.count >= this.numberCount) {
            // popUp

            System.out.println("debug menor true");
            returnValue[0] = "true";
          } else {
            System.out.println("debug menor false");
            returnValue[0] = "false";
          }
          System.out.println("value to put ret menor " + stringValue);
          this.count++;
        } else {
          this.count = 0;
        }
      } else if (this.logic.equals("maior")) {
        System.out.println("maior");
        if (this.value > this.configValue) {
          if (this.count >= this.numberCount) {
            // popUp
            System.out.println("debug true maior");
            returnValue[0] = "true";
          } else {
            System.out.println("debug false maior");
            returnValue[0] = "false";
          }

          System.out.println("value to put ret maior " + stringValue);
          this.count++;
        } else {
          this.count = 0;
        }
      }
    }

    returnValue[1] = stringValue;
    System.out.println("ret[0] " + returnValue[0] + "ret[1] " + returnValue[1]);
    return returnValue;
  }

  public void setNumberCount(int numberCount) {
    this.numberCount = numberCount;
  }

  public void setLogic(String logic) {
    this.logic = logic;
  }

  public void setPrevious(float previous) {
    this.previous = previous;
  }

  public void setValue(float value) {
    this.value = value;
  }

  public void setConfigValue(float configValue) {
    this.configValue = configValue;
  }

  public float getPrevious() {
    return this.previous;
  }
}
