import java.util.Scanner;
public class menus {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    System.out.println("Welcome to Ultimate Tic Tac Toe!");
    System.out.println("1. Start Game");
    System.out.println("2. Instructions");
    System.out.println("3. Exit");
    System.out.print("Choose an option: ");
    int choice = Integer.parseInt(scanner.nextLine());

    if(choice == 1) {
      System.out.println("Starting game...");
      updateboard.main(args);
      gamelogic.main(args);
    } else if(choice == 2) {
      instructions("main", args);
    } else if(choice == 3) {
      System.out.println("Byeeee");
      System.exit(0);
    } else {
      System.out.println("Invalid choice. Please try again.");
      main(args);
    }
  }

  public static void instructions(String calledFrom, String[] args) {
    System.out.println("Instructions:");
    System.out.println("1. The game is played on a 3x3 grid of tic-tac-toe boards.");
    System.out.println("2. Each player takes turns placing their mark (X or O) on the small tic-tac-toe boards.");
    System.out.println("3. The first player to win three small tic-tac-toe boards in a row wins the game.");
    System.out.println("4. To make a move, enter the coordinates of the small board and the cell you want to mark (e.g., '1 2' for row 1, column 2).");
    System.out.println("5. If you want to re-read the instructions, type '0' at any time during the game.");
    System.out.println("6. If you want to end the game, type '-1' at any time during the game.");
    System.out.println("");
    if(calledFrom.startsWith("game")) {
      System.out.println("Press Enter to return to the game...");
      Scanner scanner = new Scanner(System.in);
      scanner.nextLine();
      if (calledFrom.equals("gameX")) {
        gamelogic.loopX(args);
      } else if (calledFrom.equals("gameO")) {
        gamelogic.loopO(args);
      } else {
        gamelogic.main(args);
      }
    } else {
      System.out.println("Press Enter to return to the main menu...");
      Scanner scanner = new Scanner(System.in);
      scanner.nextLine();
      menus.main(args);
    }
  }
}