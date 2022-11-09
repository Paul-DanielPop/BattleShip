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


//    @Test
//    void hasErrors(){
//        Player p = new Player("joan");
//        Game game = new Game();
//        assertTrue(p.boats.get(0).getLength()==3);
//        assertTrue(game.hasErrors(0,8,0,p,0));
//        assertTrue(game.hasErrors(8,0,1,p,0));
//
//
//
//    }

    @Test
    void convertLetterToInt(){
        Game game = new Game();

        int n1 = game.accessConvertLetterToInt("A");
        assertTrue(n1 == 0);

        int n2 = game.accessConvertLetterToInt("J");
        assertTrue(n2 == 9);

        int n3 = game.accessConvertLetterToInt("K");
        assertTrue(n3 == -1);
    }

    @Test
    void convertInputToGameIndex(){
        Game game = new Game();

        int n1 = game.accessConvertInputToGameIndex(1);
        assertTrue(n1 == 0);

        int n2 = game.accessConvertInputToGameIndex(10);
        assertTrue(n2 == 9);

        int n3 = game.accessConvertInputToGameIndex(11);
        assertTrue(n3 == -1);

        int n4 = game.accessConvertInputToGameIndex(-1);
        assertTrue(n4 == -1);
    }

}