
import java.time.LocalDate;
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
  private LocalDate storedBirthday;
  
  // match data
  private HashMap<Integer, Character> answers;
  private MatchType matchType;
  private BirthdayMatch[] bdayMatches;
  private PersonalMatch[] friendshipMatches;
  private PersonalMatch[] romanticMatches;
  
  /**
   * Default constructor. Makes "empty" MatchPerson object.
   */
  public MatchPerson() {
    setName("");
    setEmail("");
    setBirthday("");
    setGender(gender);
    setPreference(preference);
    setMatchType(matchType);
    
    setAnswers(new HashMap<Integer, Character>());
    setBdayMatches(new BirthdayMatch[MATCH_ARRAY_LENGTH]);
    setFriendshipMatches(new PersonalMatch[MATCH_ARRAY_LENGTH]);
    setRomanticMatches(new PersonalMatch[MATCH_ARRAY_LENGTH]);
    setStoredBirthday(null);
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
    setBdayMatches(new BirthdayMatch[MATCH_ARRAY_LENGTH]);
    setFriendshipMatches(new PersonalMatch[MATCH_ARRAY_LENGTH]);
    setRomanticMatches(new PersonalMatch[MATCH_ARRAY_LENGTH]);
    LocalDate date = LocalDate.parse(birthday);
    System.out.println(date);
    setStoredBirthday(date);
    
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

  /**
   * Set the string birthday and the LocalDate birthday.
   * @param birthday birthday as string
   */
  public void setBirthday(String birthday) {
    this.birthday = birthday;
    if (birthday != null && birthday.length() > 0) {
      String[] monthDayYear = birthday.split("/");
      String formattedDate = String.format("%04d-%02d-%02d", Integer.parseInt(monthDayYear[2]), 
                                                             Integer.parseInt(monthDayYear[0]), 
                                                             Integer.parseInt(monthDayYear[1]));
      LocalDate date = LocalDate.parse(formattedDate);
      setStoredBirthday(date);
    }
  }
  
  public LocalDate getStoredBirthday() {
    return storedBirthday;
  }

  public void setStoredBirthday(LocalDate storedBirthday) {
    this.storedBirthday = storedBirthday;
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

  public BirthdayMatch[] getBdayMatches() {
    return bdayMatches;
  }

  public void setBdayMatches(BirthdayMatch[] bdayMatches) {
    this.bdayMatches = bdayMatches;
  }

  public PersonalMatch[] getFriendshipMatches() {
    return friendshipMatches;
  }

  public void setFriendshipMatches(PersonalMatch[] friendshipMatches) {
    this.friendshipMatches = friendshipMatches;
  }

  public PersonalMatch[] getRomanticMatches() {
    return romanticMatches;
  }

  public void setRomanticMatches(PersonalMatch[] romanticMatches) {
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
        str += String.format("%2d. %s\n", (i + 1), friendshipMatches[i].toString());
      }
    }
    return str;
  }
  
  /**
   * Return the romantic matches as strings.
   * 
   * @return the string representation
   */
  public String romanticMatchesToString() {
    String str = "";
    for (int i = 0; i < MATCH_ARRAY_LENGTH; i++) {
      if (romanticMatches[i] != null) {
        str +=  String.format("%2d. %s\n", (i + 1), romanticMatches[i].toString());
      }
    }
    return str;
  }
    
}
