public class updateboard {
  public static String[][][] board;

  public static void main(String[] args) {

    board = new String[9][3][3];
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          board[i][j][k] = "-";
        }
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
            System.out.print(board[blockIndex][row][col] + " ");
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