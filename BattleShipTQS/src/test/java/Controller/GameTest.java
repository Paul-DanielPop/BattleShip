package Controller;

import Model.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void askForGuess(){
        Player p1 = new Player("Player1");
        Player p2 = new Player("Player2");

    }


    @Test
    void hasErrors(){
        Player p = new Player("joan");
        Game game = new Game();
        assertTrue(p.boats.get(0).getLength()==3);
        assertTrue(game.hasErrors(0,8,0,p,0));
        assertTrue(game.hasErrors(8,0,1,p,0));



    }
}