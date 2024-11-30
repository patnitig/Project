/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

import java.util.ArrayList;

/**
 * A class that models each Player in the game. Players have an identifier, which should be unique.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 * 
 * @modifier Nitignakumari Patel
 * @modifier Bhoomi Jaswani
 * @modifier Amandeep Kaur
 *
 * @date November 27, 2024
 */
public class Player {

    private String name; // The unique name for this player
    private int score;   // The player's score
    private ArrayList<Card> playerCards; // The list of cards the player holds

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.playerCards = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void addToScore(int points) {
        score += points;
    }

    public ArrayList<Card> getPlayerCards() {
        return playerCards;
    }

    public void setPlayerCards(ArrayList<Card> playerCards) {
        this.playerCards = playerCards;
    }

    public boolean hasCards() {
        return !playerCards.isEmpty();
    }

    public Card playCard() {
        if (!playerCards.isEmpty()) {
            return playerCards.remove(0);
        } else {
            return null;
        }
    }
}