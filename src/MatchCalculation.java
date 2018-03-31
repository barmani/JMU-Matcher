import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Methods to help calculate matches.
 * 
 * @author Brendan Armani
 * @version 1.0
 *
 */
public class MatchCalculation {

  /**
   * Fill in the responses from the survey takers.
   * 
   * @param spreadsheet the csv unsplit spreadsheet
   * @throws IOException ioe
   */
  public static ArrayList<String[]> fillAnswersArray(File spreadsheet) throws IOException {
    ArrayList<String[]> allAnswers = new ArrayList<String[]>();
    String line = "";
    
    BufferedReader reader = new BufferedReader(new FileReader(spreadsheet));
    while ((line = reader.readLine()) != null) {
      String[] arr = line.split("\",\"");
      allAnswers.add(arr);
    }
    reader.close();
    return allAnswers;
  }
  
  
}
