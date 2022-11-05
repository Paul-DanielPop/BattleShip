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

    for (int row = 0; row < grid.length; row++)
    {
      for (int col = 0; col < grid[row].length; col++)
      {
        Location location = new Location();
        grid[row][col] = location;
      }
    }
  }
}
