/** Assignment3
  HumanPlayer.java
  @author Brittany Vanderlip
  105182221
  Nov 27, 2019
  */
import java.util.*;

/**Class HumanPlayer inherites abstract class player*/
public class HumanPlayer extends player
{
  boolean done = true;
  /**Overloaded Constructor*/
  public HumanPlayer(board gameBoard, int symbol, String name) {
    super(gameBoard, symbol, name); //Call abstract class constructor
  }

  /**Abstract method defined
     Method that allows user to enter which cell they would like to place their move. Exits the while loop only when cannot make another move*/
  public void play(board gameBoard) {
    Scanner scan = new Scanner(System.in);

    this.gameBoard = gameBoard;

    do {
      System.out.println("Where would you like to place your move?\n");
      /**Display the board and its filled cells*/
      gameBoard.displayPlayerSelectionBoard();

      System.out.print(">>");

      int option = scan.nextInt();

      /**Prompt user to enter a valid number if the cell they choose is not valid*/
      if(option < 1 || option > 9){
        System.out.println("Please enter a valid cell number.");
      }

      else
        done = gameBoard.makeMove(option, this.symbol);
    }
    while (!done);
  }
}
