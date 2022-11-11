package Model;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest{

    @Test
    void testPlayerConstructor(){
        Player p = new Player("Carles");

        assertTrue(p.hasWon()==false);
        assertTrue(p.getBoats().size() == 4);
        assertTrue(p.getPlayerBoard()!=null);
        assertTrue(p.getOppBoard()!=null);
        assertTrue(p.getName()=="Carles");
        ArrayList boats= p.getBoats();
        Boat boat = (Boat) boats.get(0);
        assertTrue(boat.getLength()==3);


    }

    @Test
    void chooseBoatPosition() {
        Player player = new Player("Carles");

        player.chooseBoatPosition(player.getBoats().get(0), 0, 0, 0);
        assertTrue(player.numBoatsAlive() == 3);
        player.chooseBoatPosition(player.getBoats().get(1), 1, 0, 0);
        assertTrue(player.numBoatsAlive() == 2);
        player.chooseBoatPosition(player.getBoats().get(2), 2, 0, 0);
        assertTrue(player.numBoatsAlive() == 1);
        player.chooseBoatPosition(player.getBoats().get(3), 3, 0, 0);
        assertTrue(player.numBoatsAlive() == 0);

        assertTrue(player.getBoats().get(0).getDirection() == 0);
        assertTrue(player.getBoats().get(0).getCoordX() == 0);
        assertTrue(player.getBoats().get(0).getCoordY() == 0);

        assertTrue(player.getBoats().get(1).getDirection() == 0);
        assertTrue(player.getBoats().get(1).getCoordX() == 0);
        assertTrue(player.getBoats().get(1).getCoordY() == 1);

        assertTrue(player.getBoats().get(2).getDirection() == 0);
        assertTrue(player.getBoats().get(2).getCoordX() == 0);
        assertTrue(player.getBoats().get(2).getCoordY() == 2);

        assertTrue(player.getBoats().get(3).getDirection() == 0);
        assertTrue(player.getBoats().get(3).getCoordX() == 0);
        assertTrue(player.getBoats().get(3).getCoordY() == 3);

        assertTrue(player.getPlayerBoard().hasShip(0,0));
        assertTrue(player.getPlayerBoard().hasShip(1,0));
        assertTrue(player.getPlayerBoard().hasShip(2,0));
        assertTrue(player.getPlayerBoard().hasShip(3,0));
    }
}