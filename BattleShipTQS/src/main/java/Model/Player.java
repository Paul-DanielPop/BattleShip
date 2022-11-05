package Model;

import java.util.ArrayList;

public class Player {
  private String name;
  private ArrayList<Little> littles;
  private ArrayList<Medium> mediums;
  private ArrayList<Big> bigs;
  private int wonGames;
  private boolean winner;

  public Player(String name) {
    this.name = name;
    littles = new ArrayList<Little>(4);
    mediums = new ArrayList<Medium>(3);
    bigs = new ArrayList<Big>(2);
    wonGames = 0;
    winner = false;
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

  public ArrayList<Medium> getMediums() {
    return mediums;
  }

  public ArrayList<Big> getBigs() {
    return bigs;
  }

  public ArrayList<Little> getLittles() {
    return littles;
  }

}
