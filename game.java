/** Assignment3
  game.java
  @author Brittany Vanderlip
  105182221
  Nov 27, 2019
  */
import java.util.*;

/**Game class that instantiates*/
class game implements global
{
  board gameBoard;
  player playerX;
  player playerO;
  int turn, i;
  boolean done = true;
  String name1, name2;

  /**Default Constructor*/
  public game() {

    /**Display the welcome message*/
    System.out.println("---------------------------------");
    System.out.println("***********Welcome To************");
    System.out.println("***************JAVA**************");
    System.out.println("************TIC TAC TOE**********");
    System.out.println("---------------------------------");
    System.out.println("  By Brittany Vanderlip (c)2019  ");
    System.out.println("---------------------------------\n");


    this.gameBoard = new board();


    /**while done is true, initiate the main menu for user*/
    while (done) {
      Scanner scan = new Scanner(System.in);
      System.out.println("\n**** Let's play Tic Tac Toe! ****");
      System.out.print("*************************************\nPlease select a game option:\n1) Human vs Human\n2) Human vs AI\n3) AI vs Advanced AI \n>> ");
      int option = scan.nextInt();

      Scanner scanner = new Scanner(System.in);

      switch (option) {
        /** Human vs Human case*/
        case 1:
          System.out.print("Please enter human player X name: \n>>");
          name1 = scanner.nextLine();
          System.out.print("Please enter human player O name: \n>>");
          name2 = scanner.nextLine();
          /**Instantiate two HumanPlayer objects for player X and player 0*/
          this.playerX = new HumanPlayer(this.gameBoard, 1, name1);
          this.playerO = new HumanPlayer(this.gameBoard, 2, name2);
          /** change the done value to break out of while loop*/
          done = false;
          break;

        /**Human vs. AI case*/
        case 2:
          System.out.print("Please enter human player X name: \n");
          name1 = scanner.nextLine();
          System.out.print("I am your opponent: AI-Bot\n");
          name2 = "AI-Bot";
          /**Instantiate a HumanPlayer object and AIPlayer object for player X and player 0*/
          this.playerX = new HumanPlayer(this.gameBoard, 1, name1);
          this.playerO = new AIPlayer(this.gameBoard, 2, name2);
          /** change the done value to break out of while loop*/
          done = false;
          break;

      /**AI vs Advanced AI case*/
      case 3:
          System.out.print("I am Advanced-AI-Bot-1! Who is my opponent?");
          System.out.println("I am your opponent! I am Advanced-AI-Bot!");
          name1 = "AI-Bot";
          name2 = "Advanced-AI-Bot";
          /**Instantiate an AIPlayer object and AdvancedAIPlayer object for player X and player 0*/
          this.playerX = new AIPlayer(this.gameBoard, 1, name1);
          this.playerO = new AdvancedAIPlayer(this.gameBoard, 2, name2);
          /** change the done value to break out of while loop*/
          done = false;
          break;
        /**If user chooses something other than 1, 2 or 2. Loop back through*/
        default:
          System.out.println("****Please enter a valid option****");
      }
    }
  }

  /**initiate the game to begin here*/
  public void start() {
    Random random = new Random();
    boolean hold = true;

    /**For "Coin Toss", determine who's turn it is randomly as 1 (playerX) or 2 (playerO)*/
    this.turn = random.nextInt(2) + 1;

    System.out.println("\n**** COIN TOSS BEGINS****\n");

    /**If turn is 1, then X starts*/
    if (this.turn == 1) {
      System.out.println(name1 + " wins the coin toss, PlayerX will start!\n");
    }

    /**If turn is 2, then O starts*/
    else {
      System.out.println(name2 + " wins the coin toss, PlayerO will start****\n");
    }

    while (hold) {
      /**X's turn*/
      if (this.turn == 1) {
        System.out.println("Player X's Turn, go ahead " + name1 + ": \n");
        /**Call the play function to allow X to choose a cell*/
        this.playerX.play(this.gameBoard);
      }

      /**O's turn*/
      else {
        System.out.println("Player O's Turn, go ahead " + name2 + ": \n");
        /**Call the play function to allow O to choose a cell*/
        this.playerO.play(this.gameBoard);
      }

      /**Break out of while loop if no more available moves*/
      if (this.gameBoard.getState() != 0)
        hold = false;

      /**Otherwise alternate the turns*/
      if (hold) {
        if (this.turn == 1) {
          this.turn = 2;
          continue;
        }
          this.turn = 1;
      }
    }

    /**Display the game board*/
    this.gameBoard.displayBoard();

    //If the current state of the borad is 3, there is no winner
    if (this.gameBoard.getState() == 3) {
      System.out.println("NO WINNER!");

    }
    //If playerX wins
    else if (this.turn == 1) {
      System.out.println("!!! The winner is: " + name1 + "!!!");
    }
    //If player O wins
    else {
      System.out.println("!!! The winner is: " + name2 + "!!!");
    }
    System.out.println("******GAME OVER******");
  }
}
