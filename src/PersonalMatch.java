/**
 * Represents a match between two people and the percentage of questions 
 * they answered similarly.
 * 
 * @author Brendan Armani
 * @version 1.0
 */
public class PersonalMatch extends Match implements Comparable<PersonalMatch> {
  private double percentage;
  
  /**
   * Constructor for a match object.
   * 
   * @param matcher person currently generating matches for 
   * @param matchee person they matched with
   * @param percentage how many questions they answered similarly
   */
  public PersonalMatch(MatchPerson matcher, MatchPerson matchee, double percentage) {
    super(matcher, matchee);
    this.percentage = percentage;
  }
  
  public String toString() {
    //return String.format("%-35s%%%2.2f", super.getMatchee().getName(), percentage * 100);
    return String.format("%-35s", super.getMatchee().getName());
  }
  
  public double getPercentage() {
    return percentage;
  }

  /**
   * Compare this match to another based on percentage of questions matched.
   * 
   * @param other Match to compare with
   * @return compare result
   */
  @Override
  public int compareTo(PersonalMatch other) {
    if (percentage < other.getPercentage()) {
      return -1;
    } else if (percentage == other.getPercentage()) {
      return 0;
    } else {
      return 1;
    }
  }
  
}

