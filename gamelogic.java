public class gamelogic {

    public static int block = 4;
    public static int row = 0;
    public static int col = 0;

    public static void main(String[] args) {

        if (updateboard.board == null) {
            updateboard.main(args);
        }

        boolean win = false;

        System.out.println("Game starts in 5th Block");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=+=|");

        while (!win) {
            loopX(args);
            loopO(args);
        }
    }

    public static void loopX(String[] args) {

        System.out.println("Player X");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=|");
        System.out.println("Row Number (1-3)");
        row = Integer.parseInt(System.console().readLine()) - 1;
        System.out.println("Column Number (1-3)");
        col = Integer.parseInt(System.console().readLine()) - 1;

        if (updateboard.board[block][row][col].equals("-")) {
            updateboard.board[block][row][col] = "X";
            updateboard.draw3DBoard(updateboard.board);
            checkThreeInRow();
        } else {
            System.out.println("Invalid move. Try again.");
            loopX(args);
            return;
        }

        block = row * 3 + col;
    }

    public static void loopO(String[] args) {

        System.out.println("Player O");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=|");
        System.out.println("Row Number (1-3)");
        row = Integer.parseInt(System.console().readLine()) - 1;
        System.out.println("Column Number (1-3)");
        col = Integer.parseInt(System.console().readLine()) - 1;

        if (updateboard.board[block][row][col].equals("-")) {
            updateboard.board[block][row][col] = "O";
            updateboard.draw3DBoard(updateboard.board);
            checkThreeInRow();
        } else {
            System.out.println("Invalid move. Try again.");
            loopO(args);
            return;
        }

        block = row * 3 + col;
    }

    public static void checkThreeInRow() {

        if (updateboard.board[block][0][0].equals(updateboard.board[block][0][1]) &&
                updateboard.board[block][0][1].equals(updateboard.board[block][0][2]) &&
                !updateboard.board[block][0][0].equals("-")) {
            System.out.println("Player " + updateboard.board[block][0][0] + " wins block " + block);
        } else if (updateboard.board[block][1][0].equals(updateboard.board[block][1][1]) &&
                updateboard.board[block][1][1].equals(updateboard.board[block][1][2]) &&
                !updateboard.board[block][1][0].equals("-")) {
            System.out.println("Player " + updateboard.board[block][1][0] + " wins block " + block);
        } else if (updateboard.board[block][2][0].equals(updateboard.board[block][2][1]) &&
                updateboard.board[block][2][1].equals(updateboard.board[block][2][2]) &&
                !updateboard.board[block][2][0].equals("-")) {
            System.out.println("Player " + updateboard.board[block][2][0] + " wins block " + block);
        } else if (updateboard.board[block][0][0].equals(updateboard.board[block][1][0]) &&
                updateboard.board[block][1][0].equals(updateboard.board[block][2][0]) &&
                !updateboard.board[block][0][0].equals("-")) {
            System.out.println("Player " + updateboard.board[block][0][0] + " wins block " + block);
        } else if (updateboard.board[block][0][1].equals(updateboard.board[block][1][1]) &&
                updateboard.board[block][1][1].equals(updateboard.board[block][2][1]) &&
                !updateboard.board[block][0][1].equals("-")) {
            System.out.println("Player " + updateboard.board[block][0][1] + " wins block " + block);
        } else if (updateboard.board[block][0][2].equals(updateboard.board[block][1][2]) &&
                updateboard.board[block][1][2].equals(updateboard.board[block][2][2]) &&
                !updateboard.board[block][0][2].equals("-")) {
            System.out.println("Player " + updateboard.board[block][0][2] + " wins block " + block);
        } else if (updateboard.board[block][0][0].equals(updateboard.board[block][1][1]) &&
                updateboard.board[block][1][1].equals(updateboard.board[block][2][2]) &&
                !updateboard.board[block][0][0].equals("-")) {
            System.out.println("Player " + updateboard.board[block][0][0] + " wins block " + block);
        } else if (updateboard.board[block][0][2].equals(updateboard.board[block][1][1]) &&
                updateboard.board[block][1][1].equals(updateboard.board[block][2][0]) &&
                !updateboard.board[block][0][2].equals("-")) {
            System.out.println("Player " + updateboard.board[block][0][2] + " wins block " + block);
        }

    }
        
}
