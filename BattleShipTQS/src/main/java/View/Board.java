package View;

import Controller.Location;

public class Board {

  private Location[][] grid;
  private int points;

  // Constants for number of rows and columns.
  public static final int NUM_ROWS = 10;
  public static final int NUM_COLS = 10;

  public Board()
  {
    grid = new Location[NUM_ROWS][NUM_COLS];

    for (int x = 0; x < grid.length; x++)
    {
      for (int y = 0; y < grid[x].length; y++)
      {
        Location location = new Location();
        grid[x][y] = location;
      }
    }
  }
  public void markHit(int row, int col)
  {
    grid[row][col].markHit();
    points++;
  }

  public void setStatus(int row, int col, int status)
  {
    grid[row][col].setStatus(status);
  }

  public int getStatus(int row, int col)
  {
    return grid[row][col].getStatus();
  }

  public boolean alreadyGuessed(int row, int col)
  {
    return !grid[row][col].isUnguessed();
  }

  public void setShip(int row, int col, boolean val)
  {
    grid[row][col].setShip(val);
  }

  public boolean hasShip(int row, int col)
  {
    return grid[row][col].hasShip();
  }

  public Location getLocationObj(int row, int col)
  {
    return grid[row][col];
  }

  public int getNumRows()
  {
    return NUM_ROWS;
  }

  public int getNumCols()
  {
    return NUM_COLS;
  }
}
