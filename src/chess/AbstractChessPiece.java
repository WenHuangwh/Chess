package chess;

import java.awt.event.MouseAdapter;

/**
 * The type Abstract chess piece.
 */
public abstract class AbstractChessPiece implements ChessPiece {

  /**
   * The Color.
   */
  protected Color color;
  /**
   * The Row.
   */
  protected int row;
  /**
   * The Col.
   */
  protected int col;
  /**
   * The constant BOTTOM row of chess board.
   */
  protected static final int BOTTOM = 0;
  /**
   * The constant TOP row of chess board.
   */
  protected static final int TOP = 7;
  /**
   * The constant LEFT column of chess board.
   */
  protected static final int LEFT = 0;
  /**
   * The constant RIGHT column of chess board.
   */
  protected static final int RIGHT = 7;

  /**
   * Instantiates a new Abstract chess piece.
   *
   * @param row   the row
   * @param col   the col
   * @param color the color
   * @throws IllegalArgumentException the illegal argument exception
   */
  public AbstractChessPiece(int row, int col, Color color) throws IllegalArgumentException {
    if (outsideBoard(row, col)) {
      throw new IllegalArgumentException("Row or column out of chess board.");
    }
    this.row = row;
    this.col = col;
    this.color = color;
  }

  @Override
  public boolean outsideBoard(int row, int col) {
    if (row < BOTTOM || row > TOP || col < LEFT || col > RIGHT) {
      return true;
    } else {
      return false;
    }
  }

  @Override
  public int getRow() {
    return this.row;
  }

  @Override
  public int getColumn() {
    return this.col;
  }

  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * All chess piece except Pawn implement this method.
   */
  @Override
  public boolean canKill(ChessPiece piece) {
    // If the given piece has the same color
    if (this.color == piece.getColor()) {
      return false;
    }
    int otherRow = piece.getRow();
    int otherCol = piece.getColumn();
    return this.canMove(otherRow, otherCol);
  }
}
