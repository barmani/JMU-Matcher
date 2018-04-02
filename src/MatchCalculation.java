import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

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
   * @param spreadsheet the tsv unsplit spreadsheet
   * @throws IOException ioe
   */
  public static ArrayList<String[]> fillAnswersArray(File spreadsheet) throws IOException {
    ArrayList<String[]> allAnswers = new ArrayList<String[]>();
    String line = "";
    
    BufferedReader reader = new BufferedReader(new FileReader(spreadsheet));
    while ((line = reader.readLine()) != null) {
      String[] arr = line.split("\t");
      allAnswers.add(arr);
    }
    reader.close();
    return allAnswers;
  }
  
  /**
   * Make a MatchPerson object from the survey responses.
   * 
   * @param responses person's responses
   * @return the filled out person object
   */
  public static MatchPerson parseResponses(String[] responses) {
    MatchPerson newPerson = new MatchPerson();
    HashMap<Integer, Character> answers = new HashMap<Integer, Character>(); 
    for (int i = 1; i < responses.length; i++) { // start at 1 to skip timestamp
      switch(i) {
        
        case 1:   newPerson.setName(responses[i]);
                  break;
                  
        case 2:   newPerson.setEmail(responses[i]);
                  break;
                  
        case 3:   newPerson.setBirthday(responses[i]);
                  break;
                  
        case 4:   
          if (responses[i].equals("Female")) {
            newPerson.setGender(Gender.FEMALE);
          } else if (responses[i].equals("Male")) {
            newPerson.setGender(Gender.MALE);
          } else if (responses[i].startsWith("Prefer")) {
            newPerson.setGender(Gender.UNDISCLOSED);
          } else {
            newPerson.setGender(Gender.OTHER);
          }
          break;
          
        case 5:
          if (responses[i].equals("Straight")) {
            newPerson.setPreference(Preference.STRAIGHT);
          } else if (responses[i].equals("Gay")) {
            newPerson.setPreference(Preference.GAY);
          } else {
            newPerson.setPreference(Preference.BI);
          }
          break;
          
        case 6:
          if (responses[i].startsWith("Romantic")) {
            newPerson.setMatchType(MatchType.ROMANTIC);
          } else if (responses[i].startsWith("Friendships")) {
            newPerson.setMatchType(MatchType.FRIENDSHIP);
          } else {
            newPerson.setMatchType(MatchType.BIRTHDAY);
          }
          break;
          
        default:    // question answer
          if (responses[i].length() > 0) {
            if (responses[i].charAt(0) == '\"') {
              answers.put(i - 6, responses[i].charAt(1));
            } else {
              answers.put(i - 6, responses[i].charAt(0));
            }
          }
          break;
        
      }
      newPerson.setAnswers(answers);
    }
    return newPerson;
  }
  
  public static ArrayList<Match> findMatches(MatchPerson person) {
    return null;
  }
  
  
  
}
