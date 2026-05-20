public class updateboard {
  public static String[][][] board;
  public static String[][] wonTiles;

  public static void main(String[] args) {

    board = new String[9][3][3];
    wonTiles = new String[3][3];
    
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) { //traverses entire game board array and sets every value to "-"
          board[i][j][k] = "-";
        }
      }
    }

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) { //traverses entire won tiles array and sets every value to "-"
        wonTiles[i][j] = "-";
      }
    }

    draw3DBoard(board);
  }

  public static void draw3DBoard(String[][][] board) {

    for (int blockRow = 0; blockRow < 3; blockRow++) {
      for (int row = 0; row < 3; row++) {
        for (int blockCol = 0; blockCol < 3; blockCol++) {
          int blockIndex = blockRow * 3 + blockCol;
          for (int col = 0; col < 3; col++) {
            System.out.print(board[blockIndex][row][col] + " ");   //initially sets up board
          }
          if (blockCol < 2) {
            System.out.print(" ");
          }
        }
        System.out.println();
      }
      if (blockRow < 2) {
        System.out.println();
      }
    }

  }
}