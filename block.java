/** Assignment3
  block.java
  @author Brittany Vanderlip
  105182221
  Nov 27, 2019
  */
/**block class that determines the states of the cells*/
public class block {
  private int state;

  /**Default Constructor*/
  public block(){
    this.state = 0;
  }

  /**Overloaded Constructor*/
  public block(int state){
    this();
    setState(state);
  }

  /**Mutator Method*/
  public int setState(int state) {
    if (isValidState(state)) {
      this.state = state;
    }
    return state;
  }


  /**Accessor Method*/
  public int getState() {
    return this.state;
  }

  /**Helper Method: To check if the state is 1 or 2 */
  public boolean isValidState(int state) {
    return (state == 1 || state == 2);
  }

  /**To String method that returns the states of the cell. Empty, X or O*/
  public String toString() {
    if (this.state == 0)
      return " ";
    if (this.state == 1) {
      return "X";
    }
    return "O";
  }
}
