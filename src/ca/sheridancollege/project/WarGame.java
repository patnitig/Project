/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author dixan
 *
 * @modifier Gagandeep Kaur
 * @modifier Jasbir Singh
 * @modifier Jobanpreet Singh
 */
public class WarGame extends Game {

    public WarGame(String name) {
        super(name);
    }

    @Override
    public void play() {
        // 1. Create a deck of cards
        ArrayList<Card> deck = new ArrayList<>();
        for (String suit : Card.SUITS) {
            for (String rank : Card.RANKS) {
                deck.add(new Card(rank, suit));
            }
        }

        // 2. Shuffle the deck
        Collections.shuffle(deck);

        // 3. Divide the deck between players
        int numPlayers = getPlayers().size();
        int cardsPerPlayer = deck.size() / numPlayers;

        for (int i = 0; i < numPlayers; i++) {
            ArrayList<Card> playerCards = new ArrayList<>();
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerCards.add(deck.remove(0));
            }
            getPlayers().get(i).setPlayerCards(playerCards);
        }

        // 4. Start the game loop
        int round = 1;
        while (true) {
            System.out.println("Round " + round + ":");
            round++;

            // 5. Each player plays a card
            ArrayList<Card> cardsInPlay = new ArrayList<>();
            for (Player player : getPlayers()) {
                ArrayList<Card> playerCards = player.getPlayerCards();
                if (!playerCards.isEmpty()) {
                    Card card = playerCards.remove(0);
                    cardsInPlay.add(card);
                    System.out.println(player.getName() + " plays: " + card);
                }
            }

            // 6. Compare the ranks of the cards
            Card highestCard = cardsInPlay.get(0);
            for (Card card : cardsInPlay) {
                if (card.getRankValue() > highestCard.getRankValue()) {
                    highestCard = card;
                }
            }

            // 7. Handle the case of a tie ("war")
            ArrayList<Player> roundWinners = new ArrayList<>();
            for (Card card : cardsInPlay) {
                if (card.getRankValue() == highestCard.getRankValue()) {
                    roundWinners.add(findPlayerByCard(card));
                }
            }

            if (roundWinners.size() == 1) {
                // One winner
                Player roundWinner = roundWinners.get(0);
                System.out.println("Round winner: " + roundWinner.getName());
                roundWinner.addToScore(1);
            } else {
                // War
                System.out.println("It's a tie! War!");
                for (Player roundWinner : roundWinners) {
                    roundWinner.addToScore(1);
                }
            }

            // 8. Continue steps 5-7 until a player wins
            for (Player player : getPlayers()) {
                if (player.getPlayerCards().isEmpty()) {
                    // Player has no more cards, game over
                    declareWinner();
                    return;
                }
            }
        }
    }

    @Override
    public void declareWinner() {
        // Find the player with the highest score
        Player winner = getPlayers().get(0);
        for (Player player : getPlayers()) {
            if (player.getScore() > winner.getScore()) {
                winner = player;
            }
        }
        System.out.println("Game over! Winner: " + winner.getName() + " with a score of " + winner.getScore());
    }

    private Player findPlayerByCard(Card card) {
        for (Player player : getPlayers()) {
            if (player.getPlayerCards().contains(card)) {
                return player;
            }
        }
        return null;
    }
}