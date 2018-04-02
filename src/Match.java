/**
 * Represents a match between two people and the percentage of questions 
 * they answered similarly.
 * 
 * @author Brendan Armani
 * @version 1.0
 */
public class Match {
  private MatchPerson matcher;
  private MatchPerson matchee;
  private double percentage;
  
  /**
   * Constructor for a match object.
   * 
   * @param matcher person currently generating matches for 
   * @param matchee person they matched with
   * @param percentage how many questions they answered similarly
   */
  public Match(MatchPerson matcher, MatchPerson matchee, double percentage) {
    this.matcher = matcher;
    this.matchee = matchee;
    this.percentage = percentage;
  }
  
  public String toString() {
    return matchee.getName() + " with " + matcher.getName() + ": " + percentage;
  }
}
