package Model;

import View.Board;

import java.util.ArrayList;
import java.util.List;

public class Player {
  private static final int[] BOAT_LENGTHS = {3, 4, 5, 6};
  private static final int NUM_BOATS = 4;
  private String name;

  private ArrayList<Boat> boats;
  private int wonGames;
  private boolean winner;

  private Board playerBoard;
  private Board oppBoard;

  public Player(String name) {
    boats = new ArrayList<Boat>();
    for(int i=0; i<NUM_BOATS; i++){
      Boat boatAux = new Boat(BOAT_LENGTHS[i]);
      boats.add(boatAux);
    }

    this.name = name;
    wonGames = 0;
    winner = false;
    playerBoard = new Board();
    oppBoard = new Board();
  }

  public String getName() {
    return name;
  }

  public int getWonGames() {
    return wonGames;
  }

  public boolean hasWon() {
    return winner;
  }

  public ArrayList<Boat> getBoats() {return boats;}
  public Board getPlayerBoard() {return playerBoard;}
  public Board getOppBoard() {return oppBoard;}

  public void addBoats(){

  }

  public int numBoatsAlive(){
   return 0;
  }

  public void chooseBoatPosition(Boat b, int row, int col, int direction) {

  }





}
