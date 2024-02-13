package com.scraps.app;
import com.scraps.app.Getting;
import com.scraps.app.Logic;
import java.util.concurrent.TimeUnit;
/**
 * Hello world!
 *
 */
public class App {
  // value 0 always gonna be the id, and value 1 gonna be the value of crash
  public static void main(String[] args) {
    Getting getting = new Getting();
    Logic logic = new Logic();
    float[] value;
    while (true) {
      value = getting.getValues();
      if (logic.getPrevious() != value[0]) {
        System.out.println("value 1: " + value[0] + "value 2:" + value[1]);
        // if getPrevious != value setIdAndValue
        // you must do the logic of delay so doesnt consume so much memory and
        // processing
        logic.setValue(value[1]);
        logic.execute();
        logic.setPrevious(value[0]);
      }
      try {
        // Sleep for 1 second
        TimeUnit.SECONDS.sleep(10);
      } catch (InterruptedException e) {
        // Handle InterruptedException
        e.printStackTrace();
      }
    }
  }
}
