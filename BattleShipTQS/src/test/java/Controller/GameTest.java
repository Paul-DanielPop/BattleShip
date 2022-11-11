package Controller;

import Model.Boat;
import Model.Player;
import View.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    void askForGuess(){
        Game g = new Game();
        Boat b = new Boat(3);
        b.setLocation(0,0);
        b.setDirection(0);  //horizontal
        g.getPlayer1().getPlayerBoard().addBoat(b);

        assertTrue(g.askForGuess(g.getPlayer2(),g.getPlayer1(),0,0));
        assertTrue(g.askForGuess(g.getPlayer2(),g.getPlayer1(),0,2));
        assertFalse(g.askForGuess(g.getPlayer2(),g.getPlayer1(),1,0));
        assertFalse(g.askForGuess(g.getPlayer2(),g.getPlayer1(),0,3));
        assertFalse(g.askForGuess(g.getPlayer2(),g.getPlayer1(),1,1));


    }




    @Test
    void validParams(){
        //decision coverage+condition coverage
        Game g = new Game();
        assertTrue(g.validParams(0,0));
        assertFalse(g.validParams(-1,12));
        assertFalse(g.validParams(4,-2));
        assertFalse(g.validParams(5,10));
    }


    @Test
    void hasErrors(){
        Player p = new Player("joan");
        Game game = new Game();
        assertTrue(p.boats.get(0).getLength()==3);
        assertTrue(game.hasErrors(0,8,0,p,0));
        assertTrue(game.hasErrors(8,0,1,p,0));
        assertFalse(game.hasErrors(7,0,1,p,0));
        assertFalse(game.hasErrors(0,7,0,p,0));
        assertTrue(game.hasErrors(0,6,0,p,3));



        Boat b = new Boat(4);
        b.setDirection(0); //horitzontal
        b.setLocation(2,2);
        game.getPlayer1().getPlayerBoard().addBoat(b);
        assertTrue(game.hasErrors(0,3,1,game.getPlayer1(),0));
        assertFalse(game.hasErrors(1,6,1,game.getPlayer1(),0));
        assertFalse(game.hasErrors(1,1,1,game.getPlayer1(),0));
        assertFalse(game.hasErrors(2,6,0,game.getPlayer1(),0));

        b.setDirection(1); //vertical
        b.setLocation(3,2);
        game.getPlayer2().getPlayerBoard().addBoat(b);
        assertFalse(game.hasErrors(3,0,0,game.getPlayer2(),0));
        assertTrue(game.hasErrors(5,0,0,game.getPlayer2(),1));
        assertFalse(game.hasErrors(6,0,0,game.getPlayer2(),1));
        assertTrue(game.hasErrors(3,0,0,game.getPlayer2(),1));

    }


    @Test
    void convertLetterToInt(){
        Game game = new Game();
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};

        for (int i = 0; i < 10; i++){
            int n = game.accessConvertLetterToInt(letters[i]);
            assertTrue(n == i);
        }
        assertTrue(game.accessConvertLetterToInt("M")==-1);
    }

   /* @Test
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
    }*/

    @Test
    void setup(){
        Game game = new Game();
        Board board = game.getPlayer1().getPlayerBoard();
        Boat boat = game.getPlayer1().getBoats().get(0);

        assertFalse(boat.getDirection()==0); //horizontal
        assertFalse(boat.getCoordX()==0);
        assertFalse(boat.getCoordY()==1);
        assertFalse(board.hasShip(1,0));
        assertFalse(board.hasShip(1,1));
        assertFalse(board.hasShip(1,2));
        assertFalse(board.hasShip(1,3));
        assertFalse(board.hasShip(2,0));

        game.setup(game.getPlayer1(),1,0,0,0);

        assertTrue(boat.getDirection()==0); //horizontal
        assertTrue(boat.getCoordX()==0);
        assertTrue(boat.getCoordY()==1);
        assertTrue(board.hasShip(1,0));
        assertTrue(board.hasShip(1,1));
        assertTrue(board.hasShip(1,2));
        assertFalse(board.hasShip(1,3));
        assertFalse(board.hasShip(2,0));

    }

}