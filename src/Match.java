/**
 * Abstract class for commonality between matches.
 * 
 * @author Brendan Armani
 * @version 1.0
 */
public abstract class Match {

  protected MatchPerson matcher;
  protected MatchPerson matchee;
  
  public Match(MatchPerson matcher, MatchPerson matchee) {
    this.setMatcher(matcher);
    this.setMatchee(matchee);
  }

  public MatchPerson getMatcher() {
    return matcher;
  }

  public void setMatcher(MatchPerson matcher) {
    this.matcher = matcher;
  }

  public MatchPerson getMatchee() {
    return matchee;
  }

  public void setMatchee(MatchPerson matchee) {
    this.matchee = matchee;
  }
  
  public abstract String toString();
}
