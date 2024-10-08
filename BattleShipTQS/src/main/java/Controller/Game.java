package Controller;

import Model.Boat;
import Model.Player;


import java.io.IOException;
import java.util.Scanner;

public class Game {

  public static Scanner reader = new Scanner(System.in);
  private static Player p1;
  private static Player p2;

  public Game(){
    p1=new Player("player1");
    p2=new Player("player2");
  }

  // En el main se simula la partida entre Player 1 y Player 2
  // Se hace uso de todos los metodos de la classe para simular la partida,
  // los parametros necesarios se piden como input en consola y se pasan a los metodos.
  public static void main(String[] args) {
    Game currentGame = new Game();

    System.out.println("\nPlayer 1 SETUP:");

    while (p1.numBoatsLeftToSet() > 0){
      for (Boat boat: p1.getBoats()){
        int row = -1;
        int col = -1;
        int dir = -1;
        boolean continua = false;
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

          if(validParams(row,col) && !hasErrors(row,col,dir,p1,boat) && dir!=-1)
            continua=true;

        }while (!continua);

        setup(p1,row, col, dir, boat);

      }
    }

    System.out.println("\nPlayer 2 SETUP:");

    while (p2.numBoatsLeftToSet() > 0){
      for (Boat boat: p2.getBoats()){
        int row = -1;
        int col = -1;
        int dir = -1;
        boolean continua=false;
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

          if(validParams(row,col) && !hasErrors(row,col,dir,p2,boat) && dir!=-1)
            continua=true;

        }while (!continua);

        setup(p2, row, col, dir, boat);


      }
    }


    do {
      boolean valid = false;
      int row = 0;
      int col = 0;
      while (!valid) {
        System.out.println("\nPlayer 1 makes guess:");
        System.out.println("\nOpponent board: ");
        p1.getOppBoard().printStatus();

        System.out.print("Type in row (A-J): ");
        String userInputRow = reader.next();
        userInputRow = userInputRow.toUpperCase();
        row = convertLetterToInt(userInputRow);

        System.out.print("Type in column (0-9): ");
        col = reader.nextInt();
        if (row <= 9 && row >= 0 && col >= 0 && col <= 9)
          valid = true;
      }

      if (askForGuess(p1, p2, row, col)) {
        System.out.print("Hit on:\t" + "row=\t" + row + "\tcol=\t" + col + "\n");
      } else {
        System.out.print("Miss on:\t" + "row=\t" + row + "\tcol=\t" + col + "\n");
      }


      valid = false;
      int row2 = 0;
      int col2 = 0;
      while (!valid){
        System.out.println("\nPlayer 2 makes guess:");
        System.out.println("\nOpponent board: ");
        p2.getOppBoard().printStatus();

        System.out.print("Type in row (A-J): ");
        String userInputRow2 = reader.next();
        userInputRow2 = userInputRow2.toUpperCase();
        row2 = convertLetterToInt(userInputRow2);

        System.out.print("Type in column (0-9): ");
        col2 = reader.nextInt();
        if(row2<=9 && row2>=0 && col2>=0 && col2<=9)
          valid=true;
      }
      if (askForGuess(p2, p1, row2, col2)){
        System.out.print("Hit on:\t" + "row=\t" + row2 + "\tcol=\t" + col2 + "\n");
      }
      else{
        System.out.print("Miss on:\t" + "row=\t" + row2 + "\tcol=\t" + col2 + "\n");
      }

    }while(!p1.getPlayerBoard().hasLost() && !p2.getPlayerBoard().hasLost());

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

  // Metodo que recoge la coordenada[row,col] donde ataca el Player p
  // y comprueba si ha golpeado o fallado en el tablero del Player opp
  protected static boolean askForGuess(Player p, Player opp, int row, int col) {
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

  // Comprueba que el row y col seleccionados por el jugador esten dentro del intervalo [0,9]
  // de los ejes del tablero.
  protected static boolean validParams(int row, int col)
  {
    if(col>=0 && col<=9 && row!=-1)
      return true;
    return false; //no valids, tornar a inserir params
  }


  // Comprueba que el barco se pueda meter en el tablero.
  // El barco introducido no puede coincidir en una coordenada donde ya haya un barco,
  // tampoco se puede introducir fuera del tablero.
  protected static boolean hasErrors(int row, int col, int dir, Player p, Boat b){
    int length = b.getLength();

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

  // Metodo que posiciona un barco en coordenada[row,col] con direccion dir para el Player p
  public static void setup(Player p, int row, int col, int dir, Boat b){
    p.chooseBoatPosition(b, row, col, dir);

    System.out.println("You have " + p.numBoatsLeftToSet() + " remaining ships to place.");
  }

  // Getter para acceder al metodo convertLetterToInt(String input) para hacer testing
  public int accessConvertLetterToInt(String input){
    return convertLetterToInt(input);
  }

  // Metodo usado para convertir la selección de fila de un jugador y convertirlo al indice(int) correcto
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
}

