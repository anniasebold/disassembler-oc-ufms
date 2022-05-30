import java.io.*;

//
// Não alterar o nome da classe!
//
class disasm {
  public static void main(String[] args) {
    if (args.length == 0)
    {
      return;
    }
    
    String filename = args[0];
    
    try ( InputStream inputStream = new FileInputStream(filename); )
    {
        
      // Aqui vem o seu código!
        
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}