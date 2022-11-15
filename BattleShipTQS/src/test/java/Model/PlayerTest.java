package Model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest{

    @Test
    void testPlayerConstructor(){
        Player p = new Player("Carles");

        assertFalse(p.hasWon());
        assertEquals(4, p.getBoats().size());
        assertNotNull(p.getPlayerBoard());
        assertNotNull(p.getOppBoard());
        assertSame("Carles", p.getName());
        ArrayList<Boat> boats= p.getBoats();
        Boat boat = (Boat) boats.get(0);
        assertEquals(3, boat.getLength());


    }


    //CAJA NEGRA
    @Test
    void numBoatsLeftToSet(){
        Player player = new Player("Carles");
        Player player2 = new Player("Player2");

        for (Boat boat : player2.getBoats()) {
            player2.chooseBoatPosition(boat,23,12,4);
            assertEquals(4,player.numBoatsLeftToSet());

        }

        assertNotEquals(5,player.numBoatsLeftToSet());
        assertEquals(4,player.numBoatsLeftToSet());
        player.chooseBoatPosition(player.getBoats().get(0), 0, 0, 0);
        assertEquals(3, player.numBoatsLeftToSet());
        player.chooseBoatPosition(player.getBoats().get(1), 1, 0, 0);
        assertEquals(2, player.numBoatsLeftToSet());
        player.chooseBoatPosition(player.getBoats().get(2), 2, 0, 0);
        assertEquals(1, player.numBoatsLeftToSet());
        player.chooseBoatPosition(player.getBoats().get(3), 3, 0, 0);
        assertEquals(0, player.numBoatsLeftToSet());
        assertNotEquals(-1,player.numBoatsLeftToSet());


    }
    @Test
    void chooseBoatPosition() {
        Player carles = new Player("Carles");
        Player joan = new Player("Joan");
        //pairwise seria de 100 combinaciones
        carles.chooseBoatPosition(carles.getBoats().get(0), 0, 0, 0);
        carles.chooseBoatPosition(carles.getBoats().get(1), 4, 0, 0);
        carles.chooseBoatPosition(carles.getBoats().get(2), 6, 0, 0);
        carles.chooseBoatPosition(carles.getBoats().get(3), 9, 0, 0);

        joan.chooseBoatPosition(joan.getBoats().get(0), 0, 0, 1);
        joan.chooseBoatPosition(joan.getBoats().get(1), 0, 4, 1);
        joan.chooseBoatPosition(joan.getBoats().get(2), 0, 6, 1);
        joan.chooseBoatPosition(joan.getBoats().get(3), 0, 9, 1);

        assertEquals(0, carles.getBoats().get(0).getDirection());
        assertEquals(0, carles.getBoats().get(0).getCoordX());
        assertEquals(0, carles.getBoats().get(0).getCoordY());

        assertEquals(0, carles.getBoats().get(1).getDirection());
        assertEquals(0, carles.getBoats().get(1).getCoordX());
        assertEquals(4, carles.getBoats().get(1).getCoordY());

        assertEquals(0, carles.getBoats().get(2).getDirection());
        assertEquals(0, carles.getBoats().get(2).getCoordX());
        assertEquals(6, carles.getBoats().get(2).getCoordY());

        assertEquals(0, carles.getBoats().get(3).getDirection());
        assertEquals(0, carles.getBoats().get(3).getCoordX());
        assertEquals(9, carles.getBoats().get(3).getCoordY());

        assertTrue(carles.getPlayerBoard().hasShip(0,0));
        assertTrue(carles.getPlayerBoard().hasShip(4,0));
        assertTrue(carles.getPlayerBoard().hasShip(6,0));
        assertTrue(carles.getPlayerBoard().hasShip(9,0));
    }
}