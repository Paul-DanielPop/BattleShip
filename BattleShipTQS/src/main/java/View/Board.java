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

  public void setStatus(int row, int col, int status)
  {
    board[row][col].setStatus(status);
  }

  public int getStatus(int row, int col)
  {
    return board[row][col].getStatus();
  }

  public boolean hasLost(){
    if(points==18)
      return true;
    return false;
  }

  public void addBoat(Boat b){
    int row = b.getCoordY();
    int col = b.getCoordX();
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

  public void setShip(int row, int col, boolean val)
  {
    board[row][col].setShip(val);
  }

  public boolean hasShip(int row, int col)
  {
    return board[row][col].hasShip();
  }



  public void printMethod(){

    System.out.print("\t");
    for (int i = 1; i <= NUM_COLS; i++)
    {
      System.out.print(i + " ");
    }
    System.out.println();

    for (int i = 0; i < NUM_ROWS; i++){
      System.out.print(switchIntToChar(i) + "\t");

      for (int j = 0; j < NUM_COLS; j++)
      {
        if (board[i][j].checkHit())
          System.out.print("X ");
        else if (board[i][j].hasShip())
        {
          // System.out.print("X ");
          if (board[i][j].getLengthOfShip() == 2)
          {
            System.out.print("D ");
          }
          else if (board[i][j].getLengthOfShip() == 3)
          {
            System.out.print("C ");
          }
          else if (board[i][j].getLengthOfShip() == 4)
          {
            System.out.print("B ");
          }
          else if (board[i][j].getLengthOfShip() == 5)
          {
            System.out.print("A ");
          }
        }
        else if (!(board[i][j].hasShip()))
        {
          System.out.print("- ");
        }

      }
      System.out.println("\t");
    }
    System.out.println();
  }

  public char switchIntToChar(int x){
    char res;

    switch (x){
      case 0:
        res = 'A';
        break;
      case 1:
        res = 'B';
        break;
      case 2:
        res = 'C';
        break;
      case 3:
        res = 'D';
        break;
      case 4:
        res = 'E';
        break;
      case 5:
        res = 'F';
        break;
      case 6:
        res = 'G';
        break;
      case 7:
        res = 'H';
        break;
      case 8:
        res = 'I';
        break;
      case 9:
        res = 'J';
        break;
      default:
        return 'Z';
    }

    return res;
  }

}
