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
    private HashMap<Integer, Character> answers;
    Matches matches;
    

    
}
