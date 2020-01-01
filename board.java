/**Board class that creates the board and determines the states of the cells when moves are made*/
public class board {
  public block[][] blocks;    //2D array of blocks to create the cells
  private int state;          //State of the blocks

  /**Default Constructor*/
  public board() {
    this.state = 0;
    this.blocks = new block[3][3];
    /**Instantiate each cell of the board. (or block)*/
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++)
      {
        this.blocks[i][j] = new block();
      }
    }
  }

  /**Method to check if the column is empty, x or o*/
  public int checkCol(int num){
    if (this.blocks[num][0].getState() != 0)
    {
      if (this.blocks[num][0].getState() == this.blocks[num][1].getState() && this.blocks[num][1].getState() == this.blocks[num][2].getState())
        return this.blocks[num][0].getState();
    }
    return 0;
  }

  /**Method to check if the diagonal is empty, x or o*/
  public int checkDiagonals(){
    if((this.blocks[0][0].getState() == 1) || (this.blocks[0][0].getState() == 2)) {
      if(this.blocks[0][0].getState() == this.blocks[1][1].getState() && this.blocks[1][1].getState() == this.blocks[2][2].getState()){
        return this.blocks[0][0].getState();
      }
    }
    if(this.blocks[0][2].getState() == 1 || this.blocks[0][2].getState() == 2){
      if(this.blocks[0][2].getState() == this.blocks[2][0].getState() && this.blocks[1][1].getState() == this.blocks[2][0].getState()){
        return this.blocks[0][2].getState();
      }
    }
    return 0;
  }

  /**Method to check if there are no winners*/
  public int checkDraw(){
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (this.blocks[i][j].getState() == 0)
          return 0; //Empty
      }
    }  return 3; //Draw
  }

  /**Method to check if the row is empty, x or o*/
    public int checkRow(int num){
      if(this.blocks[0][num].getState() == 1 || this.blocks[0][num].getState() == 2){
        if(this.blocks[0][num].getState() == this.blocks[1][num].getState() && this.blocks[1][num].getState() == this.blocks[2][num].getState())
          return this.blocks[0][num].getState();
      }
      return 0; //return empty
    }

    /**Method to display the board with the numbers in the cell*/
  public void  displayBoard() {
    System.out.println(this.blocks[0][0] + " | " + this.blocks[0][1] + " | " + this.blocks[0][2]);
    System.out.println("__|___|__");
    System.out.println(this.blocks[1][0] + " | " + this.blocks[1][1] + " | " + this.blocks[1][2]);
    System.out.println("__|___|__");
    System.out.println(this.blocks[2][0] + " | " + this.blocks[2][1] + " | " + this.blocks[2][2]);
  }


  /**Method to display the board*/
  public void displayPlayerSelectionBoard() {
      int m = 1;
      for(int i = 0 ; i < 3 ; i++){
        for(int j = 0 ; j < 3 ; j++){
          /**If the cell is empty (AKA available to play on), keep the number in the cell*/
          if(this.blocks[i][j].getState() == 0){
            System.out.print(m);
          }
          /**Otherwise put the player's selection in the board*/
          else{
            System.out.print(this.blocks[i][j]);
          }
          m++;
          if(j < 2)
            System.out.print(" | ");
        }
        /**Formatting the board*/
        System.out.print("\n");
        if(i<2)
        System.out.println("__|___|__");
      }
}


  /**Accessor method for state that calls update state*/
  public int getState() {
    return updateState();
  }


  /**Update the state based on the availability of the rows, columns, and diagnoals*/
  public int updateState() {
    int updatedState;

    updatedState = checkRow(0) + checkRow(1) + checkRow(2) + checkCol(0) + checkCol(1) + checkCol(2) + checkDiagonals();
    /**Check updated state for winner or if you can keep playing*/
    if(updatedState != 0){
      this.state = updatedState;
    }
    /**If updated state is not 0, call checkDraw() to see if there is a winner or no winner*/
    else
      this.state = checkDraw();

    return this.state;
   }

   /**Method to make a move on the board and put X or O into the cell*/
  public boolean makeMove(int block, int state) {
  int i = 0, j = 0;

    /**If statements based on which cell the user chooses to fill*/
    if (block == 1 && this.blocks[0][0].getState() == 0) {
      this.blocks[0][0].setState(state);
      return true;
    }
    else if (block == 2 && this.blocks[0][1].getState() == 0) {
       this.blocks[0][1].setState(state);
       return true;
     }
    else if (block == 3 && this.blocks[0][2].getState() == 0) {
       this.blocks[0][2].setState(state);
       return true;
     }
     else if (block == 4 && this.blocks[1][0].getState() == 0) {
       this.blocks[1][0].setState(state);
       return true;
     }
     else if (block == 5 && this.blocks[1][1].getState() == 0) {
       this.blocks[1][1].setState(state);
       return true;
     }
     else if (block == 6 && this.blocks[1][2].getState() == 0) {
       this.blocks[1][2].setState(state);
       return true;
     }
     else if (block == 7 && this.blocks[2][0].getState() == 0) {
       this.blocks[2][0].setState(state);
       return true;
     }
     else if (block == 8 && this.blocks[2][1].getState() == 0) {
       this.blocks[2][1].setState(state);
       return true;
     }
     else if (block == 9 && this.blocks[2][2].getState() == 0) {
       this.blocks[2][2].setState(state);
       return true;
     }
     /**If cell is out of bounds*/
     else if (block < 1 || block > 9) {
       return false;
     }
    /**Return false if the state is not empty*/
    return false;
    }
  }
