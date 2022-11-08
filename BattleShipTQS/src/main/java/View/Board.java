package View;

import Controller.Location;
import Model.Boat;

public class Board {

  private Location[][] board;
  private int points;

  // Constants for number of rows and columns.
  public static final int NUM_ROWS = 10;
  public static final int NUM_COLS = 10;

  public Board()
  {
    board = new Location[NUM_ROWS][NUM_COLS];

    for (int row = 0; row < board.length; row++)
    {
      for (int col = 0; col < board[row].length; col++)
      {
        Location location = new Location();
        board[row][col] = location;
      }
    }
  }

  public Location get(int row, int col){ return board[row][col]; }
  public int getPoints() { return points;}

  public void markHit(int row, int col){
    board[row][col].markHit();
    points++;
  }

  public void markMiss(int row, int col)
  {
    board[row][col].markMiss();
  }

  public boolean alreadyGuessed(int row, int col) {
    return !board[row][col].isUnguessed();
  }

  public void setStatus(int row, int col, int status) {board[row][col].setStatus(status);}

  public int getStatus(int row, int col) {return board[row][col].getStatus();}

  public boolean hasLost(){
    if(points==18)
      return true;
    return false;
  }

  public void addBoat(Boat b){
    int row = b.getCoordX();
    int col = b.getCoordY();
    int length = b.getLength();
    int dir = b.getDirection();

    if(dir == 0){
      for(int i=col; i<col+length;i++){
        board[row][i].setShip(true);
        board[row][i].setLengthOfShip(length);
        board[row][i].setDirectionOfShip(dir);
      }
    }else if(dir==1)
    {
      for(int i=row; i<row+length;i++)
      {
        board[i][col].setShip(true);
        board[i][col].setLengthOfShip(length);
        board[i][col].setDirectionOfShip(dir);
      }
    }

  }

  public void setBoat(int row, int col, boolean val) {board[row][col].setShip(val);}

  public boolean hasBoat(int row, int col) { return board[row][col].hasShip();}



}
