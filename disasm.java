import java.io.*;

class disasm {
  public static void main(String[] args) {
    if (args.length == 0)
    {
      return;
    }
    
    String filename = args[0];
    
    try ( InputStream inputStream = new FileInputStream(filename); )
    {

      long fileSize = new File(filename).length();
      byte[] allBytes = new byte[(int) fileSize];
      String str = "";
 
      int bytesRead = inputStream.read(allBytes);
      
      for(int i = 0; i < bytesRead; i++) {
        str += Character.toString(allBytes[i]);
      }
      str = str.replace(" ", "");
      System.out.println(str);

      for(int i = 0; i < str.length(); i++) {
        if(i % 4 == 0 && i != 0) {
          System.out.println(str.charAt(i));
          System.out.println(str.charAt(i - 1));
          System.out.println(str.charAt(i - 2));
          System.out.println(str.charAt(i - 3));
        }
      }
      
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}