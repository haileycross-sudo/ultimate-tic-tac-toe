public class menus {
  public static void main(String[] args) {

    System.out.println("Welcome to Ultimate Tic Tac Toe!");
    System.out.println("1. Start Game");
    System.out.println("2. Instructions");
    System.out.println("3. Exit");
    System.out.print("Choose an option: ");
    int choice = Integer.parseInt(System.console().readLine());

    if(choice == 1) {
      System.out.println("Starting game...");
      updateboard.main(args);
      gamelogic.main(args);
    } else if(choice == 2) {
      System.out.println("Instructions:");
      System.out.println("The game is played on a 3x3 grid of tic-tac-toe boards.");
      System.out.println("Players take turns placing their mark (X or O) in an empty cell.");
      System.out.println("The cell you choose determines which board your opponent must play on next.");
      System.out.println("You win a board by getting three of you designated marks in a row.");
      System.out.println("The first player to win three boards in a row wins the game.");
      System.out.println("Press Enter to return to the main menu.");
      System.console().readLine();
      main(args);
    } else if(choice == 3) {
      System.out.println("Byeeee");
      System.exit(0);
    } else {
      System.out.println("Invalid choice. Please try again.");
      main(args);
    }

  }
}