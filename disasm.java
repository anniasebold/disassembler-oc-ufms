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
      String str[] = new String[allBytes.length];
 

      int bytesRead = inputStream.read(allBytes);
      
      for(int i = 0; i < bytesRead; i++) {
        str[i] = Character.toString(allBytes[i]);
        System.out.print(str[i]);
        
        // if(i % 4 == 0) {
        //   String bytes[] = new String[4];
        //   for(int y = 0; y < bytes.length; y++) {
        //     bytes[y] = str[y];
        //     System.out.print(bytes[y]);
        //     // str[y] = null;
        //   }
        // }
      }
      
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}