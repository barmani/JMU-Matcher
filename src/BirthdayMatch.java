import java.time.LocalDate;

/**
 * Represents a match between people for close birthdays.
 * 
 * @author Brendan Armani
 * @version 1.0
 */
public class BirthdayMatch extends Match implements Comparable<BirthdayMatch> {
  
  public BirthdayMatch(MatchPerson matcher, MatchPerson matchee) {
    super(matcher, matchee);
  }

  @Override
  public int compareTo(BirthdayMatch match) {
    LocalDate matcheeDate = matchee.getStoredBirthday();
    LocalDate otherDate = match.getMatchee().getStoredBirthday();
    LocalDate matcherDate = matcher.getStoredBirthday();
    
    int monthDistanceMatchee = Math.abs(matcherDate.getMonthValue() - matcheeDate.getMonthValue());
    int monthDistanceOther = Math.abs(matcherDate.getMonthValue() - otherDate.getMonthValue());
    int dayDistanceMatchee = Math.abs(matcherDate.getDayOfMonth() - matcheeDate.getDayOfMonth());
    int dayDistanceOther = Math.abs(matcherDate.getDayOfMonth() - otherDate.getDayOfMonth());
    
    if (monthDistanceMatchee < monthDistanceOther) { // make opposite for min heap
      return 1;
    } else if (monthDistanceMatchee > monthDistanceOther) {
      return -1;
    } else { // equal case, compare days
      if (dayDistanceMatchee < dayDistanceOther) {
        return 1;
      } else if (monthDistanceMatchee > monthDistanceOther) {
        return -1;
      } else {
        return 0;
      }
    }
  }
  
  /**
   * String representation of the birthday match.
   * 
   * @return String the formatted string
   */
  public String toString() {
    return String.format("%-35s%02d/%02d", matchee.getName(),
                                          matchee.getStoredBirthday().getMonthValue(),
                                          matchee.getStoredBirthday().getDayOfMonth());
  }
}
