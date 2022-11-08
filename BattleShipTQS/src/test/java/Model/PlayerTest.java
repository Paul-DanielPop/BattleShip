package Model;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testPlayerConstructor(){
        Player p = new Player("Carles");

        assertTrue(p.hasWon()==false);
        assertTrue(p.getBoats().size() == 4);
        assertTrue(p.getPlayerBoard()!=null);
        assertTrue(p.getOppBoard()!=null);
        assertTrue(p.getName()=="Carles");
        assertTrue(p.getWonGames()==0);
        ArrayList boats= p.getBoats();
        Boat boat = (Boat) boats.get(0);
        assertTrue(boat.getLength()==3);


    }

    @Test
    void hasWon() {
    }

    @Test
    void getBoats() {
    }

    @Test
    void getPlayerBoard() {
    }

    @Test
    void getOppBoard() {
    }

    @Test
    void addBoats() {
    }

    @Test
    void numBoatsAlive() {
    }

    @Test
    void chooseBoatPosition() {
    }
}