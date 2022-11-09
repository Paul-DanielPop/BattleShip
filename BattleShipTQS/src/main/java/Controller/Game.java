package Controller;

import Model.Boat;
import Model.Player;

import java.util.Scanner;

public class Game {

  public static Scanner reader = new Scanner(System.in);

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

  public void setup(Player p){
    p.getPlayerBoard().printMethod();
    System.out.println();
    int counter = 1;
    int normalCounter = 0;

    while(p.numBoatsAlive() > 0){
      for (Boat boat: p.getBoats()){
        System.out.println("\nBoat #" + counter + ": Length-" + boat.getLength());
        int row = -1;
        int col = -1;
        int dir = -1;
        while (true){
          System.out.print("Type in row (A-J): ");
          String userInputRow = reader.next();
          userInputRow = userInputRow.toUpperCase();
          row = convertLetterToInt(userInputRow);

          System.out.print("Type in column (1-10): ");
          col = reader.nextInt();
          col = convertInputToGameIndex(col);

          System.out.print("Type in direction (0-H, 1-V): ");
          dir = reader.nextInt();

          if (col >= 0 && col <= 9 && row != -1 && dir != -1) // Check valid input
          {
            if (!hasErrors(row, col, dir, p, normalCounter)) // Check if errors will produce (out of bounds)
            {
              break;
            }
          }

          System.out.println("Invalid location!");
        }

        p.getBoats().get(normalCounter).setLocation(row, col);
        p.getBoats().get(normalCounter).setDirection(dir);
        p.getPlayerBoard().addBoat(p.getBoats().get(normalCounter));
        p.getPlayerBoard().printMethod();
        System.out.println();
        System.out.println("You have " + p.numBoatsAlive() + " remaining ships to place.");

        normalCounter++;
        counter++;
      }
    }
  }

  public int accessConvertLetterToInt(String input){
    return convertLetterToInt(input);
  }

  public int accessConvertInputToGameIndex(int input){
    return convertInputToGameIndex(input);
  }

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

  private int convertInputToGameIndex(int input){
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
  }
}
