import java.io.*;
import java.math.BigInteger;

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
      if(str.contains("4") || 
        str.contains("3") || 
        str.contains("B") || 
        str.contains("A") ||
        str.contains("2") ||
        str.contains("5") ||
        str.contains("6") ||
        str.contains("9") ||
        str.contains("8") ||
        str.contains("C") ||
        str.contains("D") ||
        str.contains("E") ||
        str.contains("7")) {
      } else {
        str = new BigInteger(str, 2).toString(16);
      }
      
      Character bytes[] = new Character[4];

      for(int i = 0; i <= str.length(); i++) {
        if(i % 4 == 0 && i != 0) {
          bytes[0] = str.charAt(i - 4);
          bytes[1] = str.charAt(i - 3);
          bytes[2] = str.charAt(i - 2);
          bytes[3] = str.charAt(i - 1);

          if(bytes[0].equals('3')) {
            System.out.print("Add " + bytes[1] + bytes[2] + bytes[3] + "\n");
          } else if(bytes[0].equals('4')) {
            System.out.print("Subt " + bytes[1] + bytes[2] + bytes[3] + "\n");
          } else if(bytes[0].equals('B')) {
            System.out.print("AddI " + bytes[1] + bytes[2] + bytes[3] + "\n");
          } else if(bytes[0].equals('A')) {
            System.out.print("Clear");
          } else if(bytes[0].equals('1')) {
            System.out.print("Load " + bytes[1] + bytes[2] + bytes[3] + "\n");
          } else if(bytes[0].equals('2')) {
            System.out.print("Store " + bytes[1] + bytes[2] + bytes[3] + "\n");
          } else if(bytes[0].equals('5')) {
            System.out.print("Input");
          } else if(bytes[0].equals('6')) {
            System.out.print("Output");
          } else if(bytes[0].equals('9')) {
            System.out.print("Jump " + bytes[1] + bytes[2] + bytes[3] + "\n");
          } else if(bytes[0].equals('8')) {
            System.out.print("Skipcond");
          } else if(bytes[0].equals('0')) {
            System.out.print("JnS " + bytes[1] + bytes[2] + bytes[3] + "\n");
          } else if(bytes[0].equals('C')) {
            System.out.print("jumpl " + bytes[1] + bytes[2] + bytes[3] + "\n");
          } else if(bytes[0].equals('D')) {
            System.out.print("LoadI");
          } else if(bytes[0].equals('E')) {
            System.out.print("StoreI");
          } else if(bytes[0].equals('7')) {
            System.out.print("Halt");
          }
        }
      }
      
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}