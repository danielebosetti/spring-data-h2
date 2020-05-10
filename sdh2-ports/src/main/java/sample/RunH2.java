package sample;

public class RunH2 {

  public static void main(String[] args) throws Exception {
   
    String[] h2arg = new String[] {
        "-tcp",
        "-tcpAllowOthers",
        "-tcpPort", "9092",
        "-web",
        "-webAllowOthers",
        "-webPort", "8082",
        //"-browser", //go to http://192.168.1.2:8082/
        //"help!",
        "-ifNotExists"
        
    };
    org.h2.tools.Server.main(h2arg);
  }
}
