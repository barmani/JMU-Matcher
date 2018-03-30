import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * Stores a participant's data. This includes their personal information and 
 * their matches.
 * 
 * @author Brendan Armani
 * @version 1.0
 */
public class MatchPerson {
  
  // personal information as appears in form
  private String name;
  private String email;
  private Date birthday;
  private Gender gender;
  private Preference preference;
  
  // match data
  private HashMap<Integer, Integer> answers;
  private MatchType matchType;
  private ArrayList<Match> bdayMatches;
  private ArrayList<Match> friendshipMatches;
  private ArrayList<Match> romanticMatches;
  
  /**
   * Constructor for person. Read from spreadsheet.
   * 
   * @param name first and last name
   * @param email dukes email
   * @param birthday bday
   * @param gender answered gender identification
   * @param preference sexual identification
   * @param matchType match type paid for
   */
  public MatchPerson(String name, String email, Date birthday, Gender gender, 
      Preference preference, MatchType matchType) {
    this.name = name;
    this.email = email;
    this.birthday = birthday;
    this.gender = gender;
    this.preference = preference;
    this.matchType = matchType;
    
    answers = new HashMap<Integer, Integer>();
    bdayMatches = new ArrayList<Match>();
    friendshipMatches = new ArrayList<Match>();
    romanticMatches = new ArrayList<Match>();    
  }

    

    
}
