public class updateboard {
  public static void main(String[] args) {

    String[][][] board = createSampleBoard();
    draw3DBoard(board);
  }

  public static void draw3DBoard(String[][][] board) {
    if (board == null || board.length != 9) {
      throw new IllegalArgumentException("Board must be a 3x3x3 structure with 9 blocks.");
    }

    for (int outerRow = 0; outerRow < 3; outerRow++) {
      for (int innerRow = 0; innerRow < 3; innerRow++) {
        for (int outerCol = 0; outerCol < 3; outerCol++) {
          int blockIndex = outerRow * 3 + outerCol;
          String[][] block = board[blockIndex];
          if (block == null || block.length != 3) {
            throw new IllegalArgumentException("Each block must be a 3x3 array.");
          }

          for (int innerCol = 0; innerCol < 3; innerCol++) {
            String value = block[innerRow][innerCol];
            System.out.print(value == null ? " " : value);
            if (innerCol < 2) {
              System.out.print(" |");
            }
          }

          if (outerCol < 2) {
            System.out.print(" || ");
          }
        }
        System.out.println();
      }

      if (outerRow < 2) {
        System.out.println("=======++=======++=======");
      }
    }
  }

  private static String[][][] createSampleBoard() {
    String[][][] board = new String[9][3][3];

    return board;
  }
}