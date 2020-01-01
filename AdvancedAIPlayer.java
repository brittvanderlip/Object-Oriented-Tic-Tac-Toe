/** Assignment3
  AdvancedAIPlayer.java
  BONUS
  @author Brittany Vanderlip
  105182221
  Nov 27, 2019
  */
/**AdvancedAIPlayer class*/
public class AdvancedAIPlayer extends player{

  /**Overlaoded Constructor*/
  public AdvancedAIPlayer(board gameBoard, int symbol, String name){
    super(gameBoard, symbol, name);
  }

  /**Play function for AdvancedAIPlayer*/
  public void play(board gameBoard){
    int option = bestMove();

    int option2 = worstMove();

    /**Make a move based on if the move is a good move.*/
    /**If the bestMove() does not return 0, then make the move at that cell*/
    if(option != 0)
      this.gameBoard.makeMove(option, symbol);
    /**If there is a bad move, then avoid it, otherwise put the move in that cell*/
    else if(option2 != 0)
      this.gameBoard.makeMove(option2, symbol);

    System.out.println("Advanced-AI-Bot has made its move!");
  }

  /**Method: bestMove to determine if there is a winning cell*/
  private int bestMove(){
    /**Call the checkWin() method*/
    int win = checkWin();

    if(win != 0){
      return win;
    }
    else{
      win = checkLegalMove();
    }
    return win;
  }

  /**Method: worstMove to determine if there is a losing cell*/
  private int worstMove(){
    int loss = checkLoss();
    if(loss != 0){
      return loss;
    }
    else{
      loss = checkLegalMove();
    }
    return loss;
  }

  /**Method to determine if there is an empty cell that will be the winning cell*/
  private int checkWin(){
    /**Checking if a row has a last empty cell for a potential win*/
    if((this.gameBoard.blocks[0][0].getState() == this.gameBoard.blocks[0][1].getState()) && this.gameBoard.blocks[0][2].getState() == 0){
      return 3;
    }
    if((this.gameBoard.blocks[1][0].getState() == this.gameBoard.blocks[1][1].getState()) && this.gameBoard.blocks[1][2].getState() == 0){
      return 6;
    }
    if((this.gameBoard.blocks[2][0].getState() == this.gameBoard.blocks[2][1].getState()) && this.gameBoard.blocks[2][2].getState() == 0){
      return 9;
    }

    /**Checking if a row has a middle empty cell for a potential win*/
    if((this.gameBoard.blocks[0][0].getState() == this.gameBoard.blocks[0][2].getState()) && this.gameBoard.blocks[0][1].getState() == 0){
      return 2;
    }
    if((this.gameBoard.blocks[1][0].getState() == this.gameBoard.blocks[1][2].getState()) && this.gameBoard.blocks[1][1].getState() == 0){
      return 5;
    }
    if((this.gameBoard.blocks[2][0].getState() == this.gameBoard.blocks[2][2].getState()) && this.gameBoard.blocks[2][1].getState() == 0){
      return 8;
    }

    /**Checking if a row has a first empty cell for a potential win*/
    if((this.gameBoard.blocks[0][1].getState() == this.gameBoard.blocks[0][2].getState()) && this.gameBoard.blocks[0][0].getState() == 0){
      return 1;
    }
    if((this.gameBoard.blocks[1][1].getState() == this.gameBoard.blocks[1][2].getState()) && this.gameBoard.blocks[1][0].getState() == 0){
      return 4;
    }
    if((this.gameBoard.blocks[2][1].getState() == this.gameBoard.blocks[2][2].getState()) && this.gameBoard.blocks[2][0].getState() == 0){
      return 7;
    }

    /**Checking if a column has a last empty cell for a potential win*/
    if((this.gameBoard.blocks[0][0].getState() == this.gameBoard.blocks[1][0].getState()) && this.gameBoard.blocks[2][0].getState() == 0){
      return 7;
    }
    if((this.gameBoard.blocks[0][1].getState() == this.gameBoard.blocks[1][1].getState()) && this.gameBoard.blocks[2][1].getState() == 0){
      return 8;
    }
    if((this.gameBoard.blocks[0][2].getState() == this.gameBoard.blocks[1][2].getState()) && this.gameBoard.blocks[2][2].getState() == 0){
      return 9;
    }

    /**Checking if a column has a middle empty cell for a potential win*/
    if((this.gameBoard.blocks[0][0].getState() == this.gameBoard.blocks[2][0].getState()) && this.gameBoard.blocks[1][0].getState() == 0){
      return 4;
    }
    if((this.gameBoard.blocks[0][1].getState() == this.gameBoard.blocks[2][1].getState()) && this.gameBoard.blocks[1][1].getState() == 0){
      return 5;
    }
    if((this.gameBoard.blocks[0][2].getState() == this.gameBoard.blocks[2][2].getState()) && this.gameBoard.blocks[1][2].getState() == 0){
      return 6;
    }

    /**Checking if a column has a first empty cell for a potential win*/
    if((this.gameBoard.blocks[1][0].getState() == this.gameBoard.blocks[2][0].getState()) && this.gameBoard.blocks[0][0].getState() == 0){
      return 1;
    }
    if((this.gameBoard.blocks[1][1].getState() == this.gameBoard.blocks[2][1].getState()) && this.gameBoard.blocks[0][1].getState() == 0){
      return 2;
    }
    if((this.gameBoard.blocks[1][2].getState() == this.gameBoard.blocks[2][2].getState()) && this.gameBoard.blocks[0][2].getState() == 0){
      return 3;
    }

    /**Checking if a right to left diagonal has an empty cell for a potential win */
    if((this.gameBoard.blocks[0][0].getState() == this.gameBoard.blocks[1][1].getState()) && this.gameBoard.blocks[2][2].getState() == 0){
      return 9;
    }
    if((this.gameBoard.blocks[0][0].getState() == this.gameBoard.blocks[2][2].getState()) && this.gameBoard.blocks[1][1].getState() == 0){
      return 5;
    }
    if((this.gameBoard.blocks[1][1].getState() == this.gameBoard.blocks[2][2].getState()) && this.gameBoard.blocks[0][0].getState() == 0){
      return 1;
    }

    /**Checking if a left to right diagonal has an empty cell for a potential win */
    if((this.gameBoard.blocks[0][2].getState() == this.gameBoard.blocks[1][1].getState()) && this.gameBoard.blocks[2][0].getState() == 0){
      return 7;
    }
    if((this.gameBoard.blocks[1][1].getState() == this.gameBoard.blocks[2][0].getState()) && this.gameBoard.blocks[0][2].getState() == 0){
      return 3;
    }
    if((this.gameBoard.blocks[2][0].getState() == this.gameBoard.blocks[0][2].getState()) && this.gameBoard.blocks[1][1].getState() == 0){
      return 5;
    }
    else
      return 0;
  }

/**Method checkLoss() to see if there is a potential losing move. If the move may lose then return 0 and don't make that move*/
private int checkLoss() {
  int move;
  /**Cases for establishing if X or O needs to be checked for a loss*/
  if (this.symbol == 1) {
    move = 1;
  }
  else {
    move = 2;
  }
  /**Loop through the rows and columns to check if the move is bad or not*/
  for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        /**If a cell is empty, enter the block below*/
        if (this.gameBoard.blocks[i][j].getState() == 0) {

        /**Incrementing k when the cell matches the current state of the cell*/
        int k = 0;
        /**Checking the rows of the board*/
        if (this.gameBoard.blocks[0][j].getState() == move)
          k++;
        if (this.gameBoard.blocks[1][j].getState() == move)
          k++;
        if (this.gameBoard.blocks[2][j].getState() == move)
          k++;
        /**When k is 2, there is one availble move. AKA a winning cell*/
        if (k == 2)
          return 3 * i + 1 + j;

        k = 0;
        /**checking the columns of the board*/
        if (this.gameBoard.blocks[i][0].getState() == move)
          k++;
        if (this.gameBoard.blocks[i][1].getState() == move)
          k++;
        if (this.gameBoard.blocks[i][2].getState() == move)
          k++;
        /**When k is 2, there is one availble move. AKA a winning cell*/
        if (k == 2)
          return 3 * i + j + 1;

        k = 0;
        /**Checking Diagonals*/
        if ((i == 0 && j == 2) || (i == 1 && j == 1) || (i == 2 && j == 0)) {

          if (this.gameBoard.blocks[0][2].getState() == move)
            k++;
          if (this.gameBoard.blocks[1][1].getState() == move)
            k++;
          if (this.gameBoard.blocks[2][0].getState() == move)
            k++;
          /**When k is 2, there is one availble move. AKA a winning cell*/
          if (k == 2)
            return 3 * i + j + 1;

        }
        k = 0;
        /**Checking the columns of the board*/
        if ((i == 0 && j == 0) || (i == 1 && j == 1) || (i == 2 && j == 2)) {

          if (this.gameBoard.blocks[0][0].getState() == move)
            k++;
          if (this.gameBoard.blocks[1][1].getState() == move)
            k++;
          if (this.gameBoard.blocks[2][2].getState() == move)
            k++;
          /**When k is 2, there is one availble move. AKA a winning cell*/
          if (k == 2)
            return 3 * i + j + 1;

        }
      }
    }
  }

  return 0;
}

  /**Method to determine if the move is allowed or not*/
  private int checkLegalMove(){
    int option = 1;
    /**Looping through each cell in the board*/
    for(int i = 0 ; i < 3 ; i++){
      for(int j = 0 ; j < 3 ; j++){
        /**if the cell is empty*/
        if(this.gameBoard.blocks[i][j].getState() != 1 || this.gameBoard.blocks[i][j].getState() != 2){
          return option;
        }
        option++;
      }
    }
    return option;
  }
}
