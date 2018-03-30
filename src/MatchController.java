import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MatchController {

  /**
   * Reads csv file, initiates match calculations, and writes to a text file.
   * @param args command line arguments
   * @throws IOException ioe
   */
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.err.println("Must provide a file to read from.");
    } else {  
      File spreadsheet = new File(args[0]);
      // get answers in ArrayList from csv
      ArrayList<String[]> allAnswers = MatchCalculation.fillAnswersArray(spreadsheet); 
    }
    
  }

}
