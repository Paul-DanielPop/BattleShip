package Controller;

import Model.Boat;
import Model.Player;

import java.util.Scanner;

public class Game {

  public static Scanner reader = new Scanner(System.in);
  private static Player p1;
  private static Player p2;

  public Game(){
    p1=new Player("player1");
    p2=new Player("player2");
  }

  public static void main(String[] args) {
    Game currentGame = new Game();

    System.out.println("\nPlayer SETUP:");

    while (p1.numBoatsAlive() > 0){
      for (Boat boat: p1.getBoats()){
        int row = -1;
        int col = -1;
        int dir = -1;
        int normCounter = 0;
        do {
          p1.getPlayerBoard().printBoats();
          System.out.print("Type in row (A-J): ");
          String userInputRow = reader.next();
          userInputRow = userInputRow.toUpperCase();
          row = convertLetterToInt(userInputRow);


          System.out.print("Type in column (0-9): ");
          col = reader.nextInt();

          System.out.print("Type in direction (0 = Horizontal, 1 = Vertical): ");
          dir = reader.nextInt();

        }while (!validParams(row, col) && dir != -1 && !hasErrors(row, col, dir, p1, normCounter));

        setup(p1,row, col, dir, normCounter);
        normCounter++;

      }
    }

    while (p2.numBoatsAlive() > 0){
      for (Boat boat: p2.getBoats()){
        int row = -1;
        int col = -1;
        int dir = -1;
        int normCounter = 0;
        do {
          p2.getPlayerBoard().printBoats();
          System.out.print("Type in row (A-J): ");
          String userInputRow = reader.next();
          userInputRow = userInputRow.toUpperCase();
          row = convertLetterToInt(userInputRow);


          System.out.print("Type in column (0-9): ");
          col = reader.nextInt();

          System.out.print("Type in direction (0 = Horizontal, 1 = Vertical): ");
          dir = reader.nextInt();

        }while (!validParams(row, col) && dir != -1 && !hasErrors(row, col, dir, p2, normCounter));

        setup(p2, row, col, dir, normCounter);
        normCounter++;

      }
    }

    do {
      System.out.println("\nPlayer 1 makes guess:");
      System.out.print("Type in row (A-J): ");
      String userInputRow = reader.next();
      userInputRow = userInputRow.toUpperCase();
      int row = convertLetterToInt(userInputRow);

      System.out.print("Type in column (0-9): ");
      int col = reader.nextInt();

      if (askForGuess(p1, p2, row, col)){
        System.out.print("Hit on:\t" + "row=\t" + row + "\tcol=\t" + col);
      }
      else{
        System.out.print("Miss on:\t" + "row=\t" + row + "\tcol=\t" + col);
      }

      System.out.println("\nPlayer 2 makes guess:");
      System.out.print("Type in row (A-J): ");
      String userInputRow2 = reader.next();
      userInputRow2 = userInputRow2.toUpperCase();
      int row2 = convertLetterToInt(userInputRow2);

      System.out.print("Type in column (0-9): ");
      int col2 = reader.nextInt();

      if (askForGuess(p1, p2, row2, col2)){
        System.out.print("Hit on:\t" + "row=\t" + row2 + "\tcol=\t" + col2);
      }
      else{
        System.out.print("Miss on:\t" + "row=\t" + row2 + "\tcol=\t" + col2);
      }

    }while(!p1.getPlayerBoard().hasLost() || !p2.getPlayerBoard().hasLost());

    if(p1.getPlayerBoard().hasLost()){
      System.out.println("Player 2 HAS WON!");
      p2.getOppBoard().printMethod();
    }

    if(p2.getPlayerBoard().hasLost()){
      System.out.println("Player 1 HAS WON!");
      p1.getOppBoard().printMethod();
    }

  }
  public Player getPlayer1(){return p1;}
  public Player getPlayer2(){return p2;}

  protected static boolean askForGuess(Player p, Player opp, int row, int col) {
    if(opp.getPlayerBoard().hasShip(row,col))
    {
      p.getOppBoard().markHit(row,col);
      opp.getPlayerBoard().markHit(row,col);
      p.getOppBoard().printStatus();
      return true;
    }
    else{
      p.getOppBoard().markMiss(row, col);
      opp.getPlayerBoard().markMiss(row,col);
      p.getOppBoard().printStatus();
      return false;
    }
  }

  protected static boolean validParams(int row, int col)
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

  public static void setup(Player p, int row, int col, int dir, int normCounter){
    p.chooseBoatPosition(p.getBoats().get(normCounter), row, col, dir);
    p.getPlayerBoard().printBoats();
    System.out.println("You have " + p.numBoatsAlive() + " remaining ships to place.");
  }

  public int accessConvertLetterToInt(String input){
    return convertLetterToInt(input);
  }

  //public int accessConvertInputToGameIndex(int input){return convertInputToGameIndex(input);}

  private static int convertLetterToInt(String input) {
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
