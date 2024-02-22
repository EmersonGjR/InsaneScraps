package com.scraps.app.model;

import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Getting {
  String urlApi = "https://api.insane.gg/crash/list";

  public Getting() {}
  // put to return float
  public float[] getValues() {
    HttpPost postRequest = new HttpPost(this.urlApi);
    setPost(postRequest);
    return sendPost(postRequest);
  }
  private float[] sendPost(HttpPost postRequest) {
    float[] returnValues = new float[2];
    System.out.println("entrou send");
    try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
      System.out.println("entrou try send");
      CloseableHttpResponse response = httpClient.execute(postRequest);
      // System.out.println(response);
      if (checkResponseHealth(response)) {
        extractValue(response, returnValues);
      }
      response.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return returnValues;
  }

  private float[] extractValue(CloseableHttpResponse response,
                               float[] returnValues) {

    try {
      System.out.println("entrou try");
      HttpEntity responseEntity = response.getEntity();
      String responseString = EntityUtils.toString(responseEntity);
      // System.out.println(responseString);
      String[] arrayString = responseString.split(":");
      String[] arrayId = arrayString[1].split(",");
      String[] arrayValue = arrayString[2].split(",");
      int i = 0;
      for (String var : arrayId) {
        System.out.println("value: " + var);
        System.out.println(i);
        i++;
      }

      System.out.println("finished one");
      i = 0;
      for (String var : arrayValue) {
        System.out.println("value: " + var);

        System.out.println(i);
        i++;
      }
      float id = Float.parseFloat(arrayId[0]);
      float value = Float.parseFloat(arrayValue[0]);
      returnValues[0] = id;
      returnValues[1] = value;

    } catch (IOException e) {

      System.out.println("fucking hell false");
      e.printStackTrace();
    }
    return returnValues;
  }
  private Boolean checkResponseHealth(CloseableHttpResponse response) {
    if (response.getStatusLine().getStatusCode() == 201) {
      System.out.println("checkResponseHealth true");
      return true;
    }
    return false;
  }

  private void setPost(HttpPost postRequest) { // Set headers:
    postRequest.setHeader("Cookie", getCookie());
    postRequest.setHeader(
        "User-Agent",
        "Mozilla/5.0 (X11; Linux x86_64; rv:121.0) Gecko/20100101 Firefox/121.0");
    postRequest.setHeader("Accept", "application/json");
    postRequest.setHeader("Content-Type", "application/json");
    postRequest.setHeader("Accept-Language", "en-US,en;q=0.5");
    postRequest.setHeader("Sec-Fetch-Dest", "empty");
    postRequest.setHeader("Sec-Fetch-Mode", "cors");
    postRequest.setHeader("Sec-Fetch-Site", "same-origin");
    postRequest.setHeader("Te", "trailers");

    // Set content type and body:
    StringEntity entity = new StringEntity("{\"room\":\"CLASSIC\"}", "UTF-8");
    entity.setContentType("application/json");
    postRequest.setEntity(entity);
  }
  private String getCookie() {
    return "cf_clearance=7pp3dME3sbWax8XCGgk0JRjal_xAy1yypFha7q8G7xo-1707682368-1-AWphUa8Rv9GMf+9kCtZfvzXMkiiho4FuF8Zr0LR4b5tzqKJOqB/IeTcmDdA0lCIvqoPLlpuz5APQC0HYctmBYgE=; _ga_SNETJTHSDZ=GS1.1.1707700159.2.0.1707700159.0.0.0; _ga=GA1.2.981133138.1707682369; _ym_uid=1707682372314905975; _ym_d=1707682372; _ym_isad=2; _gid=GA1.2.1507413529.1707682372; _ga_R2BSHD510Q=GS1.2.1707700166.2.0.1707700166.60.0.0; _fbp=fb.1.1707700165222.1781729965; _ym_visorc=w";
  }
}
