/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * The class that models your game. You should create a more specific child of this class and instantiate the methods
 * given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * 
 * @modifier Dixantkumar Patel
 * @modifier Gagandeep Kaur
 * @modifier Jasbir Singh
 * @modifier Jobanpreet Singh
 * 
 * @date June 20, 2023
 */
public abstract class Game {

    private final String war;//the title of the game
    private ArrayList<Player> players;// the players of the game

    public Game(String war) {
        this.war = war;
        players = new ArrayList();
    }

    /**
     * @return the name
     */
    public String getName() {
        return war;
    }

    /**
     * @return the players of this game
     */
    public ArrayList<Player> getPlayers() {
        return players;
    }

    /**
     * @param players the players of this game
     */
    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    /**
     * Play the game. This might be one method or many method calls depending on your game.
     */
    public abstract void play();

    /**
     * When the game is over, use this method to declare and display a winning player.
     */
    public abstract void declareWinner();

}//end class
