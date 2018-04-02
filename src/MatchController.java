import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MatchController {
   
  /**
   * Reads tsv file, initiates match calculations, and writes to a text file.
   * @param args command line arguments
   * @throws IOException ioe
   */
  public static void main(String[] args) throws IOException {
    if (args.length != 1) {
      System.err.println("Must provide a file to read from.");
    } else {  
      ArrayList<MatchPerson> allPeople = new ArrayList<MatchPerson>();

      File spreadsheet = new File(args[0]);
      // get answers in ArrayList from tsv
      ArrayList<String[]> allAnswers = MatchCalculation.fillAnswersArray(spreadsheet);
      String[] questions = allAnswers.get(0); // store questions titles (may or may not need)
      allAnswers.remove(0); // remove titles
      for (String[] arr: allAnswers) {
        allPeople.add(MatchCalculation.parseResponses(arr)); // fill in person objects
      }
//      for (MatchPerson person: allPeople) {
//        System.out.println("******************************");
//        System.out.println(person.toString());
//        System.out.println("******************************");
//      }
      // find matches
      for (MatchPerson person: allPeople) {
        MatchCalculation.findMatches(person);
      }
    }
    
  }

}
