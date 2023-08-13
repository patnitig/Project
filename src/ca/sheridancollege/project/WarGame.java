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
        System.out.println("Shuffling the deck...");
        GroupOfCards groupOfCards = new GroupOfCards(deck);
        groupOfCards.shuffle();
        deck = groupOfCards.getCards();

        // 3. Divide the deck between players
        int numPlayers = getPlayers().size();
        int cardsPerPlayer = deck.size() / numPlayers;

        for (int i = 0; i < numPlayers; i++) {
            ArrayList<Card> playerCards = new ArrayList<>();
            for (int j = 0; j < cardsPerPlayer; j++) {
                playerCards.add(deck.remove(0));
            }
            getPlayers().get(i).setPlayerCards(playerCards);
            System.out.println(getPlayers().get(i).getName() + " received " + playerCards.size() + " cards.");
        }

        // 4. Start the game loop
        int round = 1;
        while (true) {
            System.out.println("Round " + round + ":");

            // 5. Each player plays a card
            ArrayList<Card> cardsInPlay = new ArrayList<>();

            // Player 1's turn (User input)
            Player player1 = getPlayers().get(0);
            ArrayList<Card> player1Cards = player1.getPlayerCards();
            if (!player1Cards.isEmpty()) {
                System.out.println(player1.getName() + ", it's your turn. Press Enter to play a card.");
                new java.util.Scanner(System.in).nextLine(); // Wait for Enter key
                Card card1 = player1Cards.remove(0);
                cardsInPlay.add(card1);
                System.out.println(player1.getName() + " plays: " + card1);
            }

            // Player 2's turn (AI)
            Player player2 = getPlayers().get(1);
            ArrayList<Card> player2Cards = player2.getPlayerCards();
            if (!player2Cards.isEmpty()) {
                Card card2 = player2Cards.remove(0);
                cardsInPlay.add(card2);
                System.out.println(player2.getName() + " plays: " + card2);
            }

            // 6. Compare the ranks of the cards
            if (!cardsInPlay.isEmpty()) {
                int highestRank = cardsInPlay.get(0).getRankValue();
                int countHighestRank = 0;  // Track the number of cards with highest rank

                for (Card card : cardsInPlay) {
                    int rank = card.getRankValue();
                    if (rank > highestRank) {
                        highestRank = rank;
                        countHighestRank = 1;
                    } else if (rank == highestRank) {
                        countHighestRank++;
                    }
                }

                if (countHighestRank == 1) {
                    // Only one player has the highest rank
                    for (Card card : cardsInPlay) {
                        if (card.getRankValue() == highestRank) {
                            Player roundWinner = findPlayerByCard(card);
                            if (roundWinner != null) {
                                roundWinner.addToScore(1);
                            }
                        }
                    }
                } else {
                    // It's a tie
                    System.out.println("Round tied.");
                }
            }

            // Check for game over conditions
            boolean gameOver = true;
            for (Player player : getPlayers()) {
                if (!player.getPlayerCards().isEmpty()) {
                    gameOver = false;
                    break;
                }
            }

            if (gameOver) {
                declareWinner();
                return;
            }

            round++;
        }
    }

    @Override
    public void declareWinner() {
        ArrayList<Player> winners = new ArrayList<>();
        int highestScore = -1;

        for (Player player : getPlayers()) {
            int score = player.getScore();
            if (score > highestScore) {
                winners.clear();
                winners.add(player);
                highestScore = score;
            } else if (score == highestScore) {
                winners.add(player);
            }
        }

        if (!winners.isEmpty()) {
            if (winners.size() == 1) {
                Player winner = winners.get(0);
                System.out.println("Game over! Winner: " + winner.getName());
            } else {
                // Determine the player with the highest-ranking final card
                Player finalWinner = winners.get(0);
                int highestFinalRank = finalWinner.getPlayerCards().isEmpty() ? -1 : finalWinner.getPlayerCards().get(0).getRankValue();

                for (Player player : winners) {
                    if (!player.getPlayerCards().isEmpty()) {
                        int finalRank = player.getPlayerCards().get(0).getRankValue();
                        if (finalRank > highestFinalRank) {
                            highestFinalRank = finalRank;
                            finalWinner = player;
                        }
                    }
                }

                System.out.println();
                System.out.println("Game over! Winner: " + finalWinner.getName());
            }
        } else {
            System.out.println("No winners. The game ended without any rounds being played.");
        }
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
