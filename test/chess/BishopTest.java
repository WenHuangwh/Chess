package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * The type Bishop test.
 */
public class BishopTest {

  /**
   * The Bishop.
   */
  Bishop bishop;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {

    bishop = new Bishop(2, 3, Color.WHITE);
    Bishop testBlack = new Bishop(2, 3, Color.BLACK);
  }

  /**
   * Test bad set up.
   */
  @Test
  public void testBadSetUp() {
    try {
      new Bishop(-1, 1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new Bishop(9, 1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new Bishop(9, -1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
  }

  /**
   * Test outside board.
   */
  @Test
  public void outsideBoard() {
    assertFalse(bishop.outsideBoard(5,5));
    assertTrue(bishop.outsideBoard(-1, 5));
    assertTrue(bishop.outsideBoard(10, 5));
  }

  /**
   * Gets row.
   */
  @Test
  public void getRow() {
    assertEquals(2, bishop.getRow());
  }

  /**
   * Gets column.
   */
  @Test
  public void getColumn() {
    assertEquals(3, bishop.getColumn());
  }

  /**
   * Gets color.
   */
  @Test
  public void getColor() {
    assertEquals(Color.WHITE, bishop.getColor());
  }

  /**
   * Test canMove.
   */
  @Test
  public void canMove() {
    // out of board
    assertFalse(bishop.canMove(9, 9));
    // other position in board
    for (int i = 0; i < 8; i ++) {
      for (int j = 0; j < 8; j ++) {
        if (i == 2 && j == 3) {
          assertFalse(bishop.canMove(i, j));
        }
        else if (Math.abs(i - 2) == Math.abs(j - 3)) {
          assertTrue(bishop.canMove(i, j));
        }
        else {
          assertFalse(bishop.canMove(i, j));
        }
      }
    }
  }

  /**
   * Test canKill.
   */
  @Test
  public void canKill() {
    for (int i = 0; i < 8; i ++) {
      for (int j = 0; j < 8; j ++) {
        // same color
        assertFalse(bishop.canKill(new King(i, j, Color.WHITE)));
        if (i == 2 && j == 3) {
          assertFalse(bishop.canKill(new King(i, j, Color.BLACK)));
        }
        else if (Math.abs(i - 2) == Math.abs(j - 3)) {
          assertTrue(bishop.canKill(new King(i, j, Color.BLACK)));
        }
        else {
          assertFalse(bishop.canKill(new King(i, j, Color.BLACK)));
        }
      }
    }
  }
}