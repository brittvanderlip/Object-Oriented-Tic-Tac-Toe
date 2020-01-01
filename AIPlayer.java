/** Assignment3
  AIPlayer.java
  @author Brittany Vanderlip
  105182221
  Nov 27, 2019
  */
/**AI Player class */
public class AIPlayer extends player{

  /**Overloaded Constructor*/
  public AIPlayer(board gameBoard, int symbol, String name){
    super(gameBoard, symbol, name);
  }

  /**Abstract play method that allows the player to play on the board*/
  public void play(board gameBoard){

    //Call check LegalMove and store into option
    int option = checkLegalMove();

    //Call makeMove to allow AI-Bot to make its own move
    this.gameBoard.makeMove(option, symbol);
    System.out.println("AI-Bot has made its move!");
  }

  /**checkLegalMove checks to see which cells are empty and will return that option and pass into makeMove(option, 2)*/
  public int checkLegalMove(){
    int option = 1;
    /**Looping through the board and its cells*/
    for(int i = 0 ; i < 3 ; i++){
      for(int j = 0 ; j < 3 ; j++){
        if(this.gameBoard.blocks[i][j].getState() != 1 && this.gameBoard.blocks[i][j].getState() != 2){
          return option;
        }
        option++;
      }
    }
    return option;
  }
}
