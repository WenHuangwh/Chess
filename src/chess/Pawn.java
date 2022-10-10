package chess;

/**
 * The type Pawn.
 */
public class Pawn extends AbstractChessPiece {

  private static final int WHITE_START = 1;
  private static final int BLACK_START = 6;
  private static final int DISTANCE = 1;
  private static final int DISTANCE_START = 2;

  /**
   * Instantiates a new Pawn with row, column, color.
   *
   * @param row   the row
   * @param col   the col
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public Pawn(int row, int col, Color color) throws IllegalArgumentException {
    super(row, col, color);
    // White Pawn cannot be placed at row 0.
    if (this.color == Color.WHITE && this.row == BOTTOM) {
      throw new IllegalArgumentException("White Pawn cannot be placed in row 0.");
    }
    // Black Pawn cannot be placed at row 7.
    if (this.color == Color.BLACK && this.row == TOP) {
      throw new IllegalArgumentException("Black Pawn connot be placed in row 7.");
    }
  }

  @Override
  public boolean canMove(int row, int col) {
    // If the given location is outside chess board or is the same position of this piece.
    if (this.outsideBoard(row, col) || (this.row == row && this.col == col)) {
      return false;
    }
    switch (this.color) {
      case WHITE: {
        // White Pawn at row 1 can move upward 1 or 2 space.
        if (this.col == col && this.row == WHITE_START && (row - this.row == DISTANCE
            || row - this.row == DISTANCE_START)) {
          return true;
          // White Pawn at other row can move upward 1 space.
        } else if (this.col == col && row - this.row == DISTANCE) {
          return true;
        } else {
          break;
        }
      }
      case BLACK: {
        // Black Pawn at row 1 can move downward 1 or 2 space.
        if (this.col == col && this.row == BLACK_START && (row - this.row == -DISTANCE
            || row - this.row == -DISTANCE_START)) {
          return true;
          // Black Pawn at other row can move downward 1 space.
        } else if (this.col == col && row - this.row == -DISTANCE) {
          return true;
        } else {
          break;
        }
      }
    }
    return false;
  }

  @Override
  public boolean canKill(ChessPiece piece) {
    // If two piece have the same color
    if (this.color == piece.getColor()) {
      return false;
    }
    int otherRow = piece.getRow();
    int otherCol = piece.getColumn();
    switch (this.color) {
      case WHITE: {
        // If the given piece is diagonally one space upward to the white Pawn.
        if (otherRow - this.row == DISTANCE && Math.abs(otherCol - this.col) == DISTANCE) {
          return true;
        } else {
          break;
        }
      }
      case BLACK: {
        // If the given piece is diagonally one space downward to the black Pawn.
        if (otherRow - this.row == -DISTANCE && Math.abs(otherCol - this.col) == DISTANCE) {
          return true;
        } else {
          break;
        }
      }
    }
    return false;
  }

}
