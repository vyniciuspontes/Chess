/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uff.chess.screens;

import com.uff.chess.gameobjects.board.Board;
import com.uff.chess.gameobjects.GameManager;
import com.uff.chess.gameobjects.pieces.Piece;
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
    private final GameManager pm; 

    public GameScreen(Game game, boolean onlyHumans) {
        super(game);
        this.board = new Board(new Vector2(0, 0), 800, 600, ResourceManager.BACKGROUND);
        this.board.setupSpots();
        this.board.createDefaultPieces();
        
        this.pm = new GameManager(this.game, board, Piece.PieceColor.WHITE, Piece.PieceColor.BLACK, onlyHumans);
        game.addMouseListener(pm);
    }

    @Override
    public void update(double deltaTime) {
        pm.update(deltaTime);
    }

    @Override
    public void draw(Graphics graphics) {
        board.draw(graphics);

    }
}
