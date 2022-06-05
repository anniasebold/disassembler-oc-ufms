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
      int cont = 0;
 
      while ((byteRead = inputStream.read()) != -1) {
        if(Integer.toHexString(byteRead).length() == 1) {
          str += '0' + Integer.toHexString(byteRead);
        } else if(Integer.toHexString(byteRead).length() == 2) {
          str += Integer.toHexString(byteRead);
        }
        cont += 2;
        
        if(cont % 4 == 0 && cont != 0) {
          Character opcode = str.charAt(cont - 4);
          StringBuilder strByte = new StringBuilder(str.substring(cont -3, cont));
        
          if(strByte.charAt(0) == '0') {
            strByte.deleteCharAt(0);
            if(strByte.charAt(0) == '0') {
              strByte.deleteCharAt(0);
            }
          }
          
          if(opcode == '3') {
            System.out.println("add " + strByte);
          } else if(opcode == '4') {
            System.out.println("subt " + strByte);
          } else if(opcode == 'b') {
            System.out.println("addi " + strByte);
          } else if(opcode == 'a') {
            System.out.println("clear");
          } else if(opcode == '1') {
            System.out.println("load " + strByte);
          } else if(opcode == '2') {
            System.out.println("store " + strByte);
          } else if(opcode == '5') {
            System.out.println("input");
          } else if(opcode == '6') {
            System.out.println("output");
          } else if(opcode == '9') {
            System.out.println("jump " + strByte);
          } else if(opcode == '8') {
            System.out.println("skipcond " + strByte);
          } else if(opcode == '0') {
            System.out.println("jns " + strByte);
          } else if(opcode == 'c') {
            System.out.println("jumpi " + strByte);
          } else if(opcode == 'd') {
            System.out.println("loadi " + strByte);
          } else if(opcode == 'e') {
            System.out.println("storei " + strByte);
          } else if(opcode == '7') {
            System.out.println("halt");
          }
        }
      }
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}