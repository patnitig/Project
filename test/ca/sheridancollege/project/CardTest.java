/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package ca.sheridancollege.project;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author nitig
 */
public class CardTest {

    // Good tests - most common code paths
    @Test
    public void testGetRank() {
        Card card = new Card("Ace", "Hearts");
        assertEquals("Ace", card.getRank());
    }

    @Test
    public void testGetSuit() {
        Card card = new Card("King", "Spades");
        assertEquals("Spades", card.getSuit());
    }

    @Test
    public void testGetRankValueNumeric() {
        Card card = new Card("7", "Diamonds");
        assertEquals(7, card.getRankValue());
    }

    @Test
    public void testToString() {
        Card card = new Card("10", "Hearts");
        assertEquals("10 of Hearts", card.toString());
    }

    // Boundary tests - tests at the data boundary
    @Test
    public void testGetRankBoundary() {
        Card card = new Card("2", "Spades");
        assertEquals(2, card.getRankValue());
    }

    @Test
    public void testGetRankBoundaryAce() {
        Card card = new Card("Ace", "Hearts");
        assertEquals(14, card.getRankValue());
    }

    @Test
    public void testGetRankBoundaryKing() {
        Card card = new Card("King", "Diamonds");
        assertEquals(13, card.getRankValue());
    }
}
