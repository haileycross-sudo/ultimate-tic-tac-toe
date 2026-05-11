import java.util.Scanner;

public class gamelogic {

    public static int block = 4;
    public static int row = 0;
    public static int col = 0;
    public static boolean win = false;
    private static final Scanner scanner = new Scanner(System.in);

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

    private static int readIndex(String prompt, int min, int max) {
        while (true) {
            System.out.print(prompt + ": ");
            String input = scanner.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value < min || value > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                    continue;
                }
                return value - 1;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter an integer.");
            }
        }
    }

    public static void loopX(String[] args) {

        System.out.println("Player X");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=|");

        check4Empty();

        row = readIndex("Row Number (1-3)", 1, 3);
        col = readIndex("Column Number (1-3)", 1, 3);

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid input. Please enter numbers between 1 and 3.");
            loopX(args);
            return;
        } else if (updateboard.board[block][row][col].equals("-")) {
            updateboard.board[block][row][col] = "X";
            updateboard.draw3DBoard(updateboard.board);
            checkThreeInRow();
            checkBigThreeInRow();
        } else {
            System.out.println("Invalid move. Try again.");
            loopX(args);
            return;
        }

        if (win) {
            System.out.println("Player X wins block " + (block + 1));
            for (int b = 0; b<updateboard.board[block].length; b++) {
                for (int i = 0; i<updateboard.board[block][b].length; i++) {
                    updateboard.board[block][b][i] = "X";
                }
            }

            win = false;
            updateboard.draw3DBoard(updateboard.board);
        }

        block = row * 3 + col;
    }

    public static void loopO(String[] args) {

        System.out.println("Player O");
        System.out.println("=+=+=+=+=+=+=+=+=+=+=|");

        check4Empty();

        row = readIndex("Row Number (1-3)", 1, 3);
        col = readIndex("Column Number (1-3)", 1, 3);

        if (row < 0 || row > 2 || col < 0 || col > 2) {
            System.out.println("Invalid input. Please enter numbers between 1 and 3.");
            loopO(args);
            return;
        } else if (updateboard.board[block][row][col].equals("-")) {
            updateboard.board[block][row][col] = "O";
            updateboard.draw3DBoard(updateboard.board);
            checkThreeInRow();
            checkBigThreeInRow();
        } else {
            System.out.println("Invalid move. Try again.");
            loopO(args);
            return;
        }

        if (win) {
            System.out.println("Player O wins block " + (block + 1));
            for (int b = 0; b<updateboard.board[block].length; b++) {
                for (int i = 0; i<updateboard.board[block][b].length; i++) {
                    updateboard.board[block][b][i] = "O";
                }                
            }
                win = false;
                updateboard.draw3DBoard(updateboard.board);
        }

        block = row * 3 + col;
} 

    public static void checkThreeInRow() {

        if (updateboard.board[block][0][0].equals(updateboard.board[block][0][1]) &&
                updateboard.board[block][0][1].equals(updateboard.board[block][0][2]) &&
                !updateboard.board[block][0][0].equals("-")) {
            updateboard.wonTiles[block/3][block%3] = updateboard.board[block][0][0];
            win = true;
        } else if (updateboard.board[block][1][0].equals(updateboard.board[block][1][1]) &&
                updateboard.board[block][1][1].equals(updateboard.board[block][1][2]) &&
                !updateboard.board[block][1][0].equals("-")) {
            updateboard.wonTiles[block/3][block%3] = updateboard.board[block][1][0];
            win = true;
        } else if (updateboard.board[block][2][0].equals(updateboard.board[block][2][1]) &&
                updateboard.board[block][2][1].equals(updateboard.board[block][2][2]) &&
                !updateboard.board[block][2][0].equals("-")) {
            updateboard.wonTiles[block/3][block%3] = updateboard.board[block][2][0];
            win = true;
        } else if (updateboard.board[block][0][0].equals(updateboard.board[block][1][0]) &&
                updateboard.board[block][1][0].equals(updateboard.board[block][2][0]) &&
                !updateboard.board[block][0][0].equals("-")) {
            updateboard.wonTiles[block/3][block%3] = updateboard.board[block][0][0];
            win = true;
        } else if (updateboard.board[block][0][1].equals(updateboard.board[block][1][1]) &&
                updateboard.board[block][1][1].equals(updateboard.board[block][2][1]) &&
                !updateboard.board[block][0][1].equals("-")) {
            updateboard.wonTiles[block/3][block%3] = updateboard.board[block][0][1];
            win = true;
        } else if (updateboard.board[block][0][2].equals(updateboard.board[block][1][2]) &&
                updateboard.board[block][1][2].equals(updateboard.board[block][2][2]) &&
                !updateboard.board[block][0][2].equals("-")) {
            updateboard.wonTiles[block/3][block%3] = updateboard.board[block][0][2];
            win = true;
        } else if (updateboard.board[block][0][0].equals(updateboard.board[block][1][1]) &&
                updateboard.board[block][1][1].equals(updateboard.board[block][2][2]) &&
                !updateboard.board[block][0][0].equals("-")) {
            updateboard.wonTiles[block/3][block%3] = updateboard.board[block][0][0];
            win = true;
        } else if (updateboard.board[block][0][2].equals(updateboard.board[block][1][1]) &&
                updateboard.board[block][1][1].equals(updateboard.board[block][2][0]) &&
                !updateboard.board[block][0][2].equals("-")) {
            updateboard.wonTiles[block/3][block%3] = updateboard.board[block][0][2];
            win = true;
        }
    }

        public static void checkBigThreeInRow() {

        if (updateboard.wonTiles[0][0].equals(updateboard.wonTiles[0][1]) &&
                updateboard.wonTiles[0][1].equals(updateboard.wonTiles[0][2]) &&
                !updateboard.wonTiles[0][0].equals("-")) {
                winstatus(updateboard.wonTiles[0][0]);  
        } else if (updateboard.wonTiles[1][0].equals(updateboard.wonTiles[1][1]) &&
                updateboard.wonTiles[1][1].equals(updateboard.wonTiles[1][2]) &&
                !updateboard.wonTiles[1][0].equals("-")) {
                winstatus(updateboard.wonTiles[1][0]);
        } else if (updateboard.wonTiles[2][0].equals(updateboard.wonTiles[2][1]) &&
                updateboard.wonTiles[2][1].equals(updateboard.wonTiles[2][2]) &&
                !updateboard.wonTiles[2][0].equals("-")) {
                winstatus(updateboard.wonTiles[2][0]);
        } else if (updateboard.wonTiles[0][0].equals(updateboard.wonTiles[1][0]) &&
                updateboard.wonTiles[1][0].equals(updateboard.wonTiles[2][0]) &&
                !updateboard.wonTiles[0][0].equals("-")) {
                winstatus(updateboard.wonTiles[0][0]);
        } else if (updateboard.wonTiles[0][1].equals(updateboard.wonTiles[1][1]) &&
                updateboard.wonTiles[1][1].equals(updateboard.wonTiles[2][1]) &&
                !updateboard.wonTiles[0][1].equals("-")) {
                winstatus(updateboard.wonTiles[0][1]);
        } else if (updateboard.wonTiles[0][2].equals(updateboard.wonTiles[1][2]) &&
                updateboard.wonTiles[1][2].equals(updateboard.wonTiles[2][2]) &&
                !updateboard.wonTiles[0][2].equals("-")) {
                winstatus(updateboard.wonTiles[0][2]);
        } else if (updateboard.wonTiles[0][0].equals(updateboard.wonTiles[1][1]) &&
                updateboard.wonTiles[1][1].equals(updateboard.wonTiles[2][2]) &&
                !updateboard.wonTiles[0][0].equals("-")) {
                winstatus(updateboard.wonTiles[0][0]);
        } else if (updateboard.wonTiles[0][2].equals(updateboard.wonTiles[1][1]) &&
                updateboard.wonTiles[1][1].equals(updateboard.wonTiles[2][0]) &&
                !updateboard.wonTiles[0][2].equals("-")) {
                winstatus(updateboard.wonTiles[0][2]);
        } else if (isBigBoardFull()) {
                winstatus("draw");
        }
    }

    public static boolean isBigBoardFull() {
        for (int b = 0; b < updateboard.board.length; b++) {
            for (int r = 0; r < updateboard.board[b].length; r++) {
                for (int c = 0; c < updateboard.board[b][r].length; c++) {
                    if (updateboard.board[b][r][c].equals("-")) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void winstatus(String player) {

    if(player.equals("draw")){
        System.out.println("The game is a draw!");
        System.exit(0);
    } else {

        for (int b = 0; b<updateboard.board.length; b++) {
            for (int r = 0; r<updateboard.board[b].length; r++) {
                for (int c = 0; c<updateboard.board[b][r].length; c++) {
                    updateboard.board[b][r][c] = player;
                }
            }
        }

        updateboard.draw3DBoard(updateboard.board);
        System.out.println("Player " + player + " wins the game!");
        System.exit(0);
    }

    }

    public static void check4Empty(){

        boolean empty = false;

        for (int j = 0; j<updateboard.board[block].length; j++) {
            for (int k = 0; k<updateboard.board[block][j].length; k++) {
                if (updateboard.board[block][j][k].equals("-")) {
                    empty = true;
                }
            }
        }

        if (!empty) {
            System.out.println("Block " + (block + 1) + " is full. Choose a different block.");
            block = readIndex("Block number (1-9)", 1, 9);
        }
    }
}
