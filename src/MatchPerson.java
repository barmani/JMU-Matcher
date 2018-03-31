import java.util.ArrayList;
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
  private String birthday;
  private Gender gender;
  private Preference preference;
  
  // match data
  private HashMap<Integer, Integer> answers;
  private MatchType matchType;
  private ArrayList<Match> bdayMatches;
  private ArrayList<Match> friendshipMatches;
  private ArrayList<Match> romanticMatches;
  
  /**
   * Default constructor. Makes "empty" MatchPerson object.
   */
  public MatchPerson() {
    setName("");
    setEmail("");
    setBirthday(birthday);
    setGender(gender);
    setPreference(preference);
    setMatchType(matchType);
    
    setAnswers(new HashMap<Integer, Integer>());
    setBdayMatches(new ArrayList<Match>());
    setFriendshipMatches(new ArrayList<Match>());
    setRomanticMatches(new ArrayList<Match>()); 
  }
  
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
  public MatchPerson(String name, String email, String birthday, Gender gender, 
      Preference preference, MatchType matchType) {
    setName(name);
    setEmail(email);
    setBirthday(birthday);
    setGender(gender);
    setPreference(preference);
    setMatchType(matchType);
    
    setAnswers(new HashMap<Integer, Integer>());
    setBdayMatches(new ArrayList<Match>());
    setFriendshipMatches(new ArrayList<Match>());
    setRomanticMatches(new ArrayList<Match>());    
  }
  
  public HashMap<Integer, Integer> getAnswers() {
    return answers;
  }
  
  public void setAnswers(HashMap<Integer, Integer> answers) {
    this.answers = answers;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getBirthday() {
    return birthday;
  }

  public void setBirthday(String birthday) {
    this.birthday = birthday;
  }

  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public Preference getPreference() {
    return preference;
  }

  public void setPreference(Preference preference) {
    this.preference = preference;
  }

  public MatchType getMatchType() {
    return matchType;
  }

  public void setMatchType(MatchType matchType) {
    this.matchType = matchType;
  }

  public ArrayList<Match> getBdayMatches() {
    return bdayMatches;
  }

  public void setBdayMatches(ArrayList<Match> bdayMatches) {
    this.bdayMatches = bdayMatches;
  }

  public ArrayList<Match> getFriendshipMatches() {
    return friendshipMatches;
  }

  public void setFriendshipMatches(ArrayList<Match> friendshipMatches) {
    this.friendshipMatches = friendshipMatches;
  }

  public ArrayList<Match> getRomanticMatches() {
    return romanticMatches;
  }

  public void setRomanticMatches(ArrayList<Match> romanticMatches) {
    this.romanticMatches = romanticMatches;
  }
  
  /**
   * String representation of MatchPerson object.
   */
  public String toString() {
    StringBuilder builder = new StringBuilder();
    builder.append("Name: " + name + "\n");
    builder.append("Email: " + email + "\n");
    builder.append("Birthday: " + birthday + "\n");
    builder.append("Gender: " + gender + "\n");
    builder.append("Sexual Identity: " + preference + "\n");
    builder.append("Matching for: " + matchType + "\n");
    return builder.toString();
  }
    
}
