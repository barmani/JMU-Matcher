import java.io.File;

public class MatchController {

  /**
   * Reads csv file, initiates match calculations, and writes to a text file.
   * @param args command line arguments
   */
  public static void main(String[] args) {
    if (args.length != 1) {
      System.err.println("Must provide a file to read from.");
    } else {
      File spreadsheet = new File(args[0]);
      System.out.println(spreadsheet.getPath());
    }
    
  }

}
