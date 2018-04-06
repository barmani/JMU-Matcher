import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Methods to help calculate matches.
 * 
 * @author Brendan Armani
 * @version 1.0
 *
 */
public class MatchCalculation {

  public static final int QUESTION_AMOUNT = 29;
  
  public static final int MATCH_ARRAY_LENGTH = 10;
  
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
  
  /**
   * Find a person's top 10 matches given an array to look from.
   * 
   * @param matcher person matching for
   * @param people list of people to match with
   * @return their top 10 matches
   */
  public static PersonalMatch[] findMatches(MatchPerson matcher, ArrayList<MatchPerson> people) {
    PriorityQueue<PersonalMatch> matches = new PriorityQueue<PersonalMatch>();
    PersonalMatch[] matchArr;
    for (MatchPerson matchee: people) {
      if (!matchee.equals(matcher)) {
        PersonalMatch match = makeMatch(matcher, matchee);
        if (matches.size() < MATCH_ARRAY_LENGTH) {
          matches.add(match);
        } else {
          if (match.getPercentage() > matches.peek().getPercentage()) {
            matches.remove();
            matches.add(match);
          }
        }
      }
    }
    matchArr = new PersonalMatch[matches.size()];
    for (int i = matches.size() - 1; i >= 0; i--) { // add results to array
      matchArr[i] = matches.remove();
    }
    Arrays.sort(matchArr, Collections.reverseOrder());
    return matchArr; 
  }
  
  /**
   * Find a person's top 10 birthday matches.
   * 
   * @param matcher person matching for
   * @param people list of people to match with
   * @return their top 10 matches
   */
  public static PersonalMatch[] findBirthdayMatches(MatchPerson matcher, 
        ArrayList<MatchPerson> people) {
    PriorityQueue<PersonalMatch> matches = new PriorityQueue<PersonalMatch>();
    PersonalMatch[] matchArr;
    for (MatchPerson matchee: people) {
      if (!matchee.equals(matcher)) {
        PersonalMatch match = makeMatch(matcher, matchee);
        if (matches.size() < MATCH_ARRAY_LENGTH) {
          matches.add(match);
        } else {
          if (match.getPercentage() > matches.peek().getPercentage()) {
            matches.remove();
            matches.add(match);
          }
        }
      }
    }
    matchArr = new PersonalMatch[matches.size()];
    for (int i = matches.size() - 1; i >= 0; i--) { // add results to array
      matchArr[i] = matches.remove();
    }
    Arrays.sort(matchArr, Collections.reverseOrder());
    return matchArr; 
  }
  
  /**
   * Make the match between two people.
   * 
   * @param matcher person matching for
   * @param matchee person matcher matched with
   * @return the match object
   */
  public static PersonalMatch makeMatch(MatchPerson matcher, MatchPerson matchee) {
    double matchCount = 0.0;
    for (Integer question: matcher.getAnswers().keySet()) {
      if (matcher.getAnswers().get(question).equals(matchee.getAnswers().get(question))) {
        matchCount++;
      }
    }
    return new PersonalMatch(matcher, matchee, matchCount / QUESTION_AMOUNT);
  }

}
