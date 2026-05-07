public class gamelogic {

    public static int block = 4;
    public static int row = 0;
    public static int col = 0;
    public static boolean win = false;

    public static void main(String[] args) {

        if (updateboard.board == null) {
            updateboard.main(args);
        }

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

        if (win) {
            System.out.println("Player X wins block " + (block + 1));
                for (int j = 0; j<updateboard.board[block].length; j++) {
                    for (int k = 0; k<updateboard.board[block][j].length; k++) {
                        updateboard.board[block][j][k] = "X";
                    }
                }
            updateboard.draw3DBoard(updateboard.board);
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

        if (win) {
            System.out.println("Player O wins block " + (block + 1));
                for (int j = 0; j<updateboard.board[block].length; j++) {
                    for (int k = 0; k<updateboard.board[block][j].length; k++) {
                        updateboard.board[block][j][k] = "O";
                    }
                }
            updateboard.draw3DBoard(updateboard.board);
        }

        block = row * 3 + col;
    }

    public static void checkThreeInRow() {

        if (updateboard.board[block][0][0].equals(updateboard.board[block][0][1]) &&
                updateboard.board[block][0][1].equals(updateboard.board[block][0][2]) &&
                !updateboard.board[block][0][0].equals("-")) {
            win = true;
        } else if (updateboard.board[block][1][0].equals(updateboard.board[block][1][1]) &&
                updateboard.board[block][1][1].equals(updateboard.board[block][1][2]) &&
                !updateboard.board[block][1][0].equals("-")) {
            win = true;
        } else if (updateboard.board[block][2][0].equals(updateboard.board[block][2][1]) &&
                updateboard.board[block][2][1].equals(updateboard.board[block][2][2]) &&
                !updateboard.board[block][2][0].equals("-")) {
            win = true;
        } else if (updateboard.board[block][0][0].equals(updateboard.board[block][1][0]) &&
                updateboard.board[block][1][0].equals(updateboard.board[block][2][0]) &&
                !updateboard.board[block][0][0].equals("-")) {
            win = true;
        } else if (updateboard.board[block][0][1].equals(updateboard.board[block][1][1]) &&
                updateboard.board[block][1][1].equals(updateboard.board[block][2][1]) &&
                !updateboard.board[block][0][1].equals("-")) {
            win = true;
        } else if (updateboard.board[block][0][2].equals(updateboard.board[block][1][2]) &&
                updateboard.board[block][1][2].equals(updateboard.board[block][2][2]) &&
                !updateboard.board[block][0][2].equals("-")) {
            win = true;
        } else if (updateboard.board[block][0][0].equals(updateboard.board[block][1][1]) &&
                updateboard.board[block][1][1].equals(updateboard.board[block][2][2]) &&
                !updateboard.board[block][0][0].equals("-")) {
            win = true;
        } else if (updateboard.board[block][0][2].equals(updateboard.board[block][1][1]) &&
                updateboard.board[block][1][1].equals(updateboard.board[block][2][0]) &&
                !updateboard.board[block][0][2].equals("-")) {
            win = true;
        }

    }
        
}
