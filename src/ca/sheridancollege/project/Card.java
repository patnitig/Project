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
         int numericValue;
    try {
        numericValue = Integer.parseInt(rank);
    } catch (NumberFormatException e) {
        switch (rank) {
            case "Jack":
                numericValue = 11;
                break;
            case "Queen":
                numericValue = 12;
                break;
            case "King":
                numericValue = 13;
                break;
            case "Ace":
                numericValue = 14;
                break;
            default:
                numericValue = -1; // Handle invalid rank gracefully
        }
    }
    return numericValue;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}
