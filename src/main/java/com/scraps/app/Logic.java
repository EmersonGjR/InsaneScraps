package com.scraps.app;
import com.scraps.app.PopUp;
import com.scraps.app.TxtWriter;
/**
 * Hello world!
 *
 */

public class Logic {
  float value;
  float previous;
  int count = 0;
  TxtWriter txtWriter = new TxtWriter("output.txt");
  PopUp popUp = new PopUp();
  public Logic() {}

  public void execute() {
    String stringValue = String.valueOf(this.value);
    txtWriter.writeData(stringValue);
    if (this.value < 2.1) {
      if (this.count >= 5) {
        popUp.setValue(this.value);
        popUp.pop();
      }

      this.count++;
    } else {
      this.count = 0;
    }
    System.out.println("hello");
  }

  public void setPrevious(float previous) { this.previous = previous; }
  public void setValue(float value) { this.value = value; }
  public float getPrevious() { return this.previous; }
}
