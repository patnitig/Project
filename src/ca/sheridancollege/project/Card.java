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
public abstract class Card {
    //default modifier for child classes

    /**
     * Students should implement this method for their specific children classes
     *
     * @return a String representation of a card. Could be an UNO card, a
     * regular playing card etc.
     *
     */
    private String rank;
    private String suit;

    /**
     * Card object with the given rank and suit.
     *
     * The rank of the card (e.g., "Ace", "2", "3", ..., "King") The suit of the
     * card (e.g., "Spades", "Hearts", "Diamonds","Clubs")
     */
    public Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    //Return the rank of the card 
    public String getRank() {
        return rank;
    }

    //Return the suit of the card
    public String getSuit() {
        return suit;
    }

    //Print Line
    @Override
    public String toString() {
        return rank + " of " + suit;
    }

}
