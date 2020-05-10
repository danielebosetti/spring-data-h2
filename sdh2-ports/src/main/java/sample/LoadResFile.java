package sample;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class LoadResFile {

  public static void main(String[] args) throws Exception {
    String pwd = System.getProperty("user.dir").replace("\\", "/");
    String url = String.format("file:///%s/src/main/resources/list-url.txt", pwd);
    InputStream is = new URL(url).openStream();
    System.out.println(toBaos(is).toString("UTF-8"));
  }

  /*
   * read into a byte-array os
   */
  static ByteArrayOutputStream toBaos(InputStream inputStream) throws IOException {
    ByteArrayOutputStream baos = new ByteArrayOutputStream();
    byte[] buffer = new byte[1024];
    int length = 0;
    while ((length = inputStream.read(buffer)) != -1) {
      baos.write(buffer, 0, length);
    }
    return baos;
  }
}
