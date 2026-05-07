public class gamelogic {

    public static int block = 4;

    public static void main(String[] args) {

        if (updateboard.board == null) {
            updateboard.main(args);
        }

        boolean win = false;

        System.out.println("Player 1 is X and Player 2 is O.");
        System.out.println("Game starts in 4th Block");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=|");

        while (!win) {
            loopX(args);
            loopO(args);
        }
    }

    public static void loopX(String[] args) {

        System.out.println("Player 1");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=|");
        System.out.println("Row Number (1-3)");
        int row = Integer.parseInt(System.console().readLine()) - 1;
        System.out.println("Column Number (1-3)");
        int col = Integer.parseInt(System.console().readLine()) - 1;

        if (updateboard.board[block][row][col].equals("-")) {
            updateboard.board[block][row][col] = "X";
            updateboard.draw3DBoard(updateboard.board);
        } else {
            System.out.println("Invalid move. Try again.");
            loopX(args);
            return;
        }

        block = row * 3 + col;
    }

    public static void loopO(String[] args) {

        System.out.println("Player 2");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=|");
        System.out.println("Row Number (1-3)");
        int row2 = Integer.parseInt(System.console().readLine()) - 1;
        System.out.println("Column Number (1-3)");
        int col2 = Integer.parseInt(System.console().readLine()) - 1;

        if (updateboard.board[block][row2][col2].equals("-")) {
            updateboard.board[block][row2][col2] = "O";
            updateboard.draw3DBoard(updateboard.board);
        } else {
            System.out.println("Invalid move. Try again.");
            loopO(args);
            return;
        }

        block = row2 * 3 + col2;
    }
}
