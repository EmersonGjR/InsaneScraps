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
  int count = 0;

  // PopUp popUp = new PopUp();
  public Logic() {
    // set to init the graphic
    // popUp.init();
  }

  public String[] compute() {
    String[] returnValue = new String[2];
    String stringValue = String.valueOf(this.value);
    if (this.logic != null) {
      if (this.logic == "menor") {
        if (this.value > this.configValue) {
          if (this.count >= 5) {
            returnValue[0] = "true";
          } else {
            returnValue[0] = "false";
          }

          returnValue[1] = stringValue;
          this.count++;
          return returnValue;
        }
        this.count = 0;
      } else if (this.logic == "maior") {
        if (this.value < this.configValue) {
          if (this.count >= 5) {
            returnValue[0] = "true";
          } else {
            returnValue[0] = "false";
          }

          returnValue[1] = stringValue;
          this.count++;
          return returnValue;
        }
        this.count = 0;
      }
    }

    return null;
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
