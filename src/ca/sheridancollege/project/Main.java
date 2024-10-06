/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

/**
 *
 * @author nitig
 */
public class Main {
    public static void main(String[] args) {
        WarGame warGame = new WarGame("War Card Game") {};
        warGame.getPlayers().add(new Player("Player 1") {
            @Override
            public void play() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        warGame.getPlayers().add(new Player("Player 2") {
            @Override
            public void play() {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });
        warGame.play();
    }
}
