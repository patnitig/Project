/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package ca.sheridancollege.project;

/**
 * A class to be used as the base Card class for the project. Must be general
 * enough to be instantiated for any Card game. Students wishing to add to the
 * code should remember to add themselves as a modifier.
 *
 * @author dancye
 *
 * @modifier Dixantkumar Patel
 * @modifier Gagandeep Kaur
 * @modifier Jasbir Singh
 * @modifier Jobanpreet Singh
 *
 * @date June 20, 2023
 *
 */
public class Card {

    private final String rank;
    private final String suit;

    // Define valid suits and ranks for a standard deck of cards
    public static final String[] SUITS = {"Hearts", "Diamonds", "Clubs", "Spades"};
    public static final String[] RANKS = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    // Returns the numerical value of the rank for comparison
    public int getRankValue() {
        // Assuming the ranks are "2", "3", ..., "10", "Jack", "Queen", "King", "Ace"
        if (rank.equals("Jack")) {
            return 11;
        } else if (rank.equals("Queen")) {
            return 12;
        } else if (rank.equals("King")) {
            return 13;
        } else if (rank.equals("Ace")) {
            return 14;
        } else {
            return Integer.parseInt(rank);
        }
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
