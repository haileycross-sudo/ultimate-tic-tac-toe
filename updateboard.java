public class updateboard {
  public static void main(String[] args) {

    String[][][] board = new String[9][3][3];
    draw3DBoard(board);
    
  }

  public static void draw3DBoard(String[][][] board) {

    for (int i = 0; i < 10; i++) {
      for (int j = 0; j < 3; j++) {
        for (int k = 0; k < 3; k++) {
          System.out.print(board[i][j][k] + " ");
        }
        System.out.println();
      }
      System.out.println();
    }

  }
}