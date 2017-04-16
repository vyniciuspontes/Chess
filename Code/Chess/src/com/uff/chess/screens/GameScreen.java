/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.chess.screens;

import com.uff.chess.gameobjects.Board;
import com.uff.chess.gameobjects.Player;
import com.uff.chess.utils.ResourceManager;
import com.vpontes.gameframework.core.Game;
import com.vpontes.gameframework.core.Screen;
import com.vpontes.gameframework.math.Vector2;
import java.awt.Graphics;

/**
 *
 * @author Vynicius Pontes
 */
public class GameScreen extends Screen {

    private final Board board;
    private final Player player1;
    private final Player player2;
    
    public GameScreen(Game game) {
        super(game);
        board = new Board(new Vector2(0,0), 800, 600, ResourceManager.BACKGROUND);
        player1 = new Player();
        player2 = new Player();
        game.addMouseListener(board);
    }
    
    @Override
    public void update(double deltaTime) {
    }

    @Override
    public void draw(Graphics graphics) {
        board.draw(graphics);
    }
}
