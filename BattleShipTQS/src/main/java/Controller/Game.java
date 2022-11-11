package Controller;

import Model.Boat;
import Model.Player;

import java.util.Scanner;

public class Game {

  public static Scanner reader = new Scanner(System.in);
  private Player p1;
  private Player p2;

  public Game(){
    p1=new Player("player1");
    p2=new Player("player2");
  }

  public Player getPlayer1(){return p1;}
  public Player getPlayer2(){return p2;}

  protected boolean askForGuess(Player p, Player opp, int row, int col) {
    if(opp.getPlayerBoard().hasShip(row,col))
    {
      p.getOppBoard().markHit(row,col);
      opp.getPlayerBoard().markHit(row,col);
      return true;
    }
    else{
      p.getOppBoard().markMiss(row, col);
      opp.getPlayerBoard().markMiss(row,col);
      return false;
    }
  }

  protected boolean validParams(int row, int col)
  {
    if(col>=0 && col<=9 && row!=-1)
      return true;
    return false; //no valids, tornar a inserir params
  }


  protected static boolean hasErrors(int row, int col, int dir, Player p, int count){
    int length = p.boats.get(count).getLength();

    if(dir==0){
      int checker = length+col;
      if(checker>10){
        System.out.println("EL BARCO NO CABE");
        return true;
      }
    }
    if (dir == 1) {
      int checker=length+row;
      if(checker>10){
        System.out.println("EL BARCO NO CABE");
        return true;
      }
    }

    if(dir==0){
      for(int i=col; i<col+length;i++)
      {
        if(p.getPlayerBoard().hasShip(row,i))
        {
          System.out.println("YA HAY UN BARCO AQUI");
          return true;
        }
      }
    }

    if(dir==1){
      for(int i=row; i<row+length;i++)
      {
        if(p.getPlayerBoard().hasShip(i,col))
        {
          System.out.println("YA HAY UN BARCO AQUI");
          return true;
        }
      }
    }


    return false;
  }

  public void setup(Player p, int row, int col, int dir, int normCounter){
    p.getBoats().get(normCounter).setLocation(col,row); // x,y (x columnes, y files)
    p.getBoats().get(normCounter).setDirection(dir);

    Boat boat = p.getBoats().get(normCounter);
    p.getPlayerBoard().addBoat(boat);
  }

  public int accessConvertLetterToInt(String input){
    return convertLetterToInt(input);
  }

  //public int accessConvertInputToGameIndex(int input){return convertInputToGameIndex(input);}

  private int convertLetterToInt(String input) {
    int toReturn = -1;
    switch (input)
    {
      case "A":   toReturn = 0;
        break;
      case "B":   toReturn = 1;
        break;
      case "C":   toReturn = 2;
        break;
      case "D":   toReturn = 3;
        break;
      case "E":   toReturn = 4;
        break;
      case "F":   toReturn = 5;
        break;
      case "G":   toReturn = 6;
        break;
      case "H":   toReturn = 7;
        break;
      case "I":   toReturn = 8;
        break;
      case "J":   toReturn = 9;
        break;
      default:    toReturn = -1;
        break;
    }

    return toReturn;
  }

  /*private int convertInputToGameIndex(int input){
    int toReturn = -1;
    switch (input)
    {
      case 1:   toReturn = 0;
        break;
      case 2:   toReturn = 1;
        break;
      case 3:   toReturn = 2;
        break;
      case 4:   toReturn = 3;
        break;
      case 5:   toReturn = 4;
        break;
      case 6:   toReturn = 5;
        break;
      case 7:   toReturn = 6;
        break;
      case 8:   toReturn = 7;
        break;
      case 9:   toReturn = 8;
        break;
      case 10:   toReturn = 9;
        break;
      default:    toReturn = -1;
        break;
    }

    return toReturn;
  }*/
}
