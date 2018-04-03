
import java.util.HashMap;

/**
 * Stores a participant's data. This includes their personal information and 
 * their matches.
 * 
 * @author Brendan Armani
 * @version 1.0
 */
public class MatchPerson {
  
  public static final int MATCH_ARRAY_LENGTH = 10;

  // personal information as appears in form
  private String name;
  private String email;
  private String birthday;
  private Gender gender;
  private Preference preference;
  
  // match data
  private HashMap<Integer, Character> answers;
  private MatchType matchType;
  private Match[] bdayMatches;
  private Match[] friendshipMatches;
  private Match[] romanticMatches;
  
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
    
    setAnswers(new HashMap<Integer, Character>());
    setBdayMatches(new Match[MATCH_ARRAY_LENGTH]);
    setFriendshipMatches(new Match[MATCH_ARRAY_LENGTH]);
    setRomanticMatches(new Match[MATCH_ARRAY_LENGTH]); 
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
    
    setAnswers(new HashMap<Integer, Character>());
    setBdayMatches(new Match[MATCH_ARRAY_LENGTH]);
    setFriendshipMatches(new Match[MATCH_ARRAY_LENGTH]);
    setRomanticMatches(new Match[MATCH_ARRAY_LENGTH]);    
  }
  
  public HashMap<Integer, Character> getAnswers() {
    return answers;
  }
  
  public void setAnswers(HashMap<Integer, Character> answers) {
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

  public Match[] getBdayMatches() {
    return bdayMatches;
  }

  public void setBdayMatches(Match[] bdayMatches) {
    this.bdayMatches = bdayMatches;
  }

  public Match[] getFriendshipMatches() {
    return friendshipMatches;
  }

  public void setFriendshipMatches(Match[] friendshipMatches) {
    this.friendshipMatches = friendshipMatches;
  }

  public Match[] getRomanticMatches() {
    return romanticMatches;
  }

  public void setRomanticMatches(Match[] romanticMatches) {
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
    for (Integer i: answers.keySet()) {
      builder.append("Question " + i + " answer: " + answers.get(i) + "\n");
    }
    return builder.toString();
  }
  
  /**
   * Determine if this person the same as another person in the system. Only test 
   * email because people may enter survey again under a different name.
   * 
   * @param other other person
   * @return whether they are equal
   */
  public boolean equals(MatchPerson other) {
    return email.equals(other.email);
  }
  
  /**
   * Return the friendship matches as strings.
   * 
   * @return the string representation
   */
  public String friendshipMatchesToString() {
    String str = "";
    for (int i = 0; i < MATCH_ARRAY_LENGTH; i++) {
      if (friendshipMatches[i] != null) {
        str +=  (i + 1) + ". " + friendshipMatches[i].toString() + "\n";
      }
    }
    return str;
  }
    
}
