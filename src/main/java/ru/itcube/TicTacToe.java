package ru.itcube;

import ru.itcube.game.Game;

public class TicTacToe {
    public static void main(String[] args) {
        Game game = new Game();
        while (!game.player1Won() && !game.player2Won()) {
            if (game.whoNext() == 1) {
                game.player1Turn();
                game.print();
                if (game.player1Won()) System.out.println("Игрок 1 победил");
                else game.changeTurn();
            } else if (game.whoNext() == 2) {
                game.player2Turn();
                game.print();
                if (game.player2Won()) System.out.println("Игрок 2 победил");
                else game.changeTurn();
            }
        }
    }
}
