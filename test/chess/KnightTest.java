package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

/**
 * The type Knight test.
 */
public class KnightTest {

  /**
   * The Knight.
   */
  Knight knight;

  /**
   * Sets up.
   */
  @Before
  public void setUp() {
    knight = new Knight(2, 3, Color.WHITE);
    Knight testBlack = new Knight(3, 5, Color.BLACK);
  }

  /**
   * Test bad set up.
   */
  @Test
  public void testBadSetUp() {
    try {
      new Knight(-1, 1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new Knight(9, 1, Color.BLACK);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
    try {
      new Knight(9, -1, Color.WHITE);
      fail("Illegal row or column.");
    } catch (IllegalArgumentException e) {
    }
  }

  /**
   * Test outside board.
   */
  @Test
  public void outsideBoard() {
    assertFalse(knight.outsideBoard(5,5));
    assertTrue(knight.outsideBoard(-1, 5));
    assertTrue(knight.outsideBoard(10, 5));
  }

  /**
   * Gets row.
   */
  @Test
  public void getRow() {
    assertEquals(2, knight.getRow());
  }

  /**
   * Gets column.
   */
  @Test
  public void getColumn() {
    assertEquals(3, knight.getColumn());
  }

  /**
   * Gets color.
   */
  @Test
  public void getColor() {
    assertEquals(Color.WHITE, knight.getColor());
    assertEquals(Color.BLACK, new Knight(1, 1, Color.BLACK).getColor());
  }

  /**
   * Test canMove.
   */
  @Test
  public void canMove() {
    // out of board
    assertFalse(knight.canMove(9, 9));
    // other position in board
    for (int i = 0; i < 8; i ++) {
      for (int j = 0; j < 8; j ++) {
        if (Math.abs(i - 2) == 1 && Math.abs(j - 3) == 2) {
          assertTrue(knight.canMove(i, j));
        }
        else if (Math.abs(i - 2) == 2 && Math.abs(j - 3) == 1) {
          assertTrue(knight.canMove(i, j));
        }
        else {
          assertFalse(knight.canMove(i, j));
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
        assertFalse(knight.canKill(new King(i, j, Color.WHITE)));
        // other color
        if (Math.abs(i - 2) == 1 && Math.abs(j - 3) == 2) {
          assertTrue(knight.canKill(new King(i, j, Color.BLACK)));
        }
        else if (Math.abs(i - 2) == 2 && Math.abs(j - 3) == 1) {
          assertTrue(knight.canKill(new King(i, j, Color.BLACK)));
        }
        else {
          assertFalse(knight.canKill(new King(i, j, Color.BLACK)));
        }
      }
    }
  }
}