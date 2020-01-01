/** Assignment3
  player.java
  @author Brittany Vanderlip
  105182221
  Nov 27, 2019
  */
/**Abstract class player*/
abstract class player{

  public int symbol;    //Symbol cannot be <0 or >9
  public String name;   //Cannot be empty
  public board gameBoard;

  /**Default Constructor*/
  public player(){
    this.symbol = 0;
    this.name = "No Name";
    this.gameBoard = gameBoard;
  }

  /**Overloaded Constructor*/
  public player(board gameBoard, int symbol, String name){
    this();
    this.gameBoard = gameBoard;
    this.symbol = setSymbol(symbol);
    this.name = setName(name);
  }

  /**Mutator Methods*/
  public int setSymbol(int symbol){
    if(isValidSymbol(symbol)){
      this.symbol = symbol;
    }
    return symbol;
  }

  public String setName(String name){
    if(isValidName(name)){
      this.name = name;
    }
    return name;
  }

  /**Accessor Methods*/
  public int getSymbol(){
    return symbol;
  }

  public String getName(){
    return name;
  }

  /**HeLPER METHODS: To check if symbol is 0, 1, or 2 and if name is empty respectively*/
  private boolean isValidSymbol(int symbol){
    return(symbol == 0 || symbol == 1 || symbol == 2);
  }

  private boolean isValidName(String name){
    return(!name.isEmpty());
  }

  /**Abstract method play that takes in the board parameter gameBoard*/
  public abstract void play(board gameBoard);


  public String toString(){
    return this.name;
  }
}
