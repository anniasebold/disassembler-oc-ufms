import java.io.*;

class disasm {
  public static void main(String[] args) {
    if (args.length == 0)
    {
      return;
    }
    
    String filename = args[0];
    
    try (InputStream inputStream = new FileInputStream(filename)) {
      int byteRead = -1;
      String str = "";
 
      while ((byteRead = inputStream.read()) != -1) {
        if(Integer.toHexString(byteRead).equals("0") || Integer.toHexString(byteRead).equals("1")) {
          String temp = "0" + Integer.toHexString(byteRead);
          str += temp;
        } else {
          str += Integer.toHexString(byteRead);
        }
      }
      
      str = str.toUpperCase();

      Character bytes[] = new Character[4];
      for(int i = 0; i <= str.length(); i++) {
        if(i % 4 == 0 && i != 0) {
          bytes[0] = str.charAt(i - 4);
          bytes[1] = str.charAt(i - 3);
          bytes[2] = str.charAt(i - 2);
          bytes[3] = str.charAt(i - 1);

          if(bytes[0].equals('3')) {
            System.out.println("add " + bytes[1] + bytes[2] + bytes[3]);
          } else if(bytes[0].equals('4')) {
            System.out.println("subt " + bytes[1] + bytes[2] + bytes[3]);
          } else if(bytes[0].equals('B')) {
            System.out.println("addi " + bytes[1] + bytes[2] + bytes[3]);
          } else if(bytes[0].equals('A')) {
            System.out.println("clear");
          } else if(bytes[0].equals('1')) {
            System.out.println("load " + bytes[1] + bytes[2] + bytes[3]);
          } else if(bytes[0].equals('2')) {
            System.out.println("store " + bytes[1] + bytes[2] + bytes[3]);
          } else if(bytes[0].equals('5')) {
            System.out.println("input");
          } else if(bytes[0].equals('6')) {
            System.out.println("output");
          } else if(bytes[0].equals('9')) {
            System.out.println("jump " + bytes[1] + bytes[2] + bytes[3] );
          } else if(bytes[0].equals('8')) {
            System.out.println("skipcond");
          } else if(bytes[0].equals('0')) {
            System.out.println("jns " + bytes[1] + bytes[2] + bytes[3]);
          } else if(bytes[0].equals('C')) {
            System.out.println("jumpi " + bytes[1] + bytes[2] + bytes[3]);
          } else if(bytes[0].equals('D')) {
            System.out.println("loadi");
          } else if(bytes[0].equals('E')) {
            System.out.println("storei");
          } else if(bytes[0].equals('7')) {
            System.out.println("halt");
          }
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}