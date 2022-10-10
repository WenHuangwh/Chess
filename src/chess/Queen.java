package chess;

/**
 * The type Queen.
 */
public class Queen extends AbstractChessPiece {

  /**
   * Instantiates a new Queen with row, column, color.
   *
   * @param row   the row
   * @param col   the col
   * @param color the color
   */
  public Queen(int row, int col, Color color) {
    super(row, col, color);
  }

  @Override
  public boolean canMove(int row, int col) {
    // If the given location is outside chess board or is the same position of this piece.
    if (outsideBoard(row, col) || (this.row == row && this.col == col)) {
      return false;
    }
    // Moving any spaces horizontally, vertically and diagonally.
    if (this.row == row || this.col == col || Math.abs(this.row - row) == Math.abs(
        this.col - col)) {
      return true;
    }
    return false;
  }
}
