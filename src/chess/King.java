package chess;

/**
 * The type King.
 */
public class King extends AbstractChessPiece {

  /**
   * Instantiates a new King with row, column, color.
   *
   * @param row   the row
   * @param col   the col
   * @param color the color
   */
  public King(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    // If the given location is outside chess board or is the same position of this piece.
    if (outsideBoard(row, col) || (this.row == row && this.col == col)) {
      return false;
    }
    // Moving one space only horizontally, vertically and diagonally.
    if (Math.abs(this.row - row) <= 1 && Math.abs(this.col - col) <= 1) {
      return true;
    }
    return false;
  }
}
